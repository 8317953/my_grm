//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.haut.grm.activiti.override;

import com.haut.grm.activiti.override.GrmProcessDiagramCanvas.SHAPE_TYPE;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.activiti.bpmn.model.Activity;
import org.activiti.bpmn.model.Artifact;
import org.activiti.bpmn.model.Association;
import org.activiti.bpmn.model.AssociationDirection;
import org.activiti.bpmn.model.BaseElement;
import org.activiti.bpmn.model.BoundaryEvent;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.BusinessRuleTask;
import org.activiti.bpmn.model.CallActivity;
import org.activiti.bpmn.model.CompensateEventDefinition;
import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.ErrorEventDefinition;
import org.activiti.bpmn.model.Event;
import org.activiti.bpmn.model.EventDefinition;
import org.activiti.bpmn.model.EventGateway;
import org.activiti.bpmn.model.EventSubProcess;
import org.activiti.bpmn.model.ExclusiveGateway;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.FlowElementsContainer;
import org.activiti.bpmn.model.FlowNode;
import org.activiti.bpmn.model.Gateway;
import org.activiti.bpmn.model.GraphicInfo;
import org.activiti.bpmn.model.InclusiveGateway;
import org.activiti.bpmn.model.IntermediateCatchEvent;
import org.activiti.bpmn.model.Lane;
import org.activiti.bpmn.model.ManualTask;
import org.activiti.bpmn.model.MessageEventDefinition;
import org.activiti.bpmn.model.MultiInstanceLoopCharacteristics;
import org.activiti.bpmn.model.ParallelGateway;
import org.activiti.bpmn.model.Pool;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.ReceiveTask;
import org.activiti.bpmn.model.ScriptTask;
import org.activiti.bpmn.model.SendTask;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.bpmn.model.ServiceTask;
import org.activiti.bpmn.model.SignalEventDefinition;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.bpmn.model.SubProcess;
import org.activiti.bpmn.model.Task;
import org.activiti.bpmn.model.TextAnnotation;
import org.activiti.bpmn.model.ThrowEvent;
import org.activiti.bpmn.model.TimerEventDefinition;
import org.activiti.bpmn.model.UserTask;
import org.activiti.image.ProcessDiagramGenerator;

public class GrmProcessDiagramGenerator implements ProcessDiagramGenerator {
    protected Map<Class<? extends BaseElement>, GrmProcessDiagramGenerator.ActivityDrawInstruction> activityDrawInstructions;
    protected Map<Class<? extends BaseElement>, GrmProcessDiagramGenerator.ArtifactDrawInstruction> artifactDrawInstructions;

    public GrmProcessDiagramGenerator() {
        this(1.0D);
    }

    public GrmProcessDiagramGenerator(final double scaleFactor) {
        this.activityDrawInstructions = new HashMap();
        this.artifactDrawInstructions = new HashMap();
        this.activityDrawInstructions.put(StartEvent.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                StartEvent startEvent = (StartEvent)flowNode;
                if (startEvent.getEventDefinitions() != null && !startEvent.getEventDefinitions().isEmpty()) {
                    EventDefinition eventDefinition = (EventDefinition)startEvent.getEventDefinitions().get(0);
                    if (eventDefinition instanceof TimerEventDefinition) {
                        processDiagramCanvas.drawTimerStartEvent(graphicInfo, scaleFactor);
                    } else if (eventDefinition instanceof ErrorEventDefinition) {
                        processDiagramCanvas.drawErrorStartEvent(graphicInfo, scaleFactor);
                    } else if (eventDefinition instanceof SignalEventDefinition) {
                        processDiagramCanvas.drawSignalStartEvent(graphicInfo, scaleFactor);
                    } else if (eventDefinition instanceof MessageEventDefinition) {
                        processDiagramCanvas.drawMessageStartEvent(graphicInfo, scaleFactor);
                    } else {
                        processDiagramCanvas.drawNoneStartEvent(graphicInfo);
                    }
                } else {
                    processDiagramCanvas.drawNoneStartEvent(graphicInfo);
                }

            }
        });
        this.activityDrawInstructions.put(IntermediateCatchEvent.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                IntermediateCatchEvent intermediateCatchEvent = (IntermediateCatchEvent)flowNode;
                if (intermediateCatchEvent.getEventDefinitions() != null && !intermediateCatchEvent.getEventDefinitions().isEmpty()) {
                    if (intermediateCatchEvent.getEventDefinitions().get(0) instanceof SignalEventDefinition) {
                        processDiagramCanvas.drawCatchingSignalEvent(flowNode.getName(), graphicInfo, true, scaleFactor);
                    } else if (intermediateCatchEvent.getEventDefinitions().get(0) instanceof TimerEventDefinition) {
                        processDiagramCanvas.drawCatchingTimerEvent(flowNode.getName(), graphicInfo, true, scaleFactor);
                    } else if (intermediateCatchEvent.getEventDefinitions().get(0) instanceof MessageEventDefinition) {
                        processDiagramCanvas.drawCatchingMessageEvent(flowNode.getName(), graphicInfo, true, scaleFactor);
                    }
                }

            }
        });
        this.activityDrawInstructions.put(ThrowEvent.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                ThrowEvent throwEvent = (ThrowEvent)flowNode;
                if (throwEvent.getEventDefinitions() != null && !throwEvent.getEventDefinitions().isEmpty()) {
                    if (throwEvent.getEventDefinitions().get(0) instanceof SignalEventDefinition) {
                        processDiagramCanvas.drawThrowingSignalEvent(graphicInfo, scaleFactor);
                    } else if (throwEvent.getEventDefinitions().get(0) instanceof CompensateEventDefinition) {
                        processDiagramCanvas.drawThrowingCompensateEvent(graphicInfo, scaleFactor);
                    } else {
                        processDiagramCanvas.drawThrowingNoneEvent(graphicInfo, scaleFactor);
                    }
                } else {
                    processDiagramCanvas.drawThrowingNoneEvent(graphicInfo, scaleFactor);
                }

            }
        });
        this.activityDrawInstructions.put(EndEvent.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                EndEvent endEvent = (EndEvent)flowNode;
                if (endEvent.getEventDefinitions() != null && !endEvent.getEventDefinitions().isEmpty()) {
                    if (endEvent.getEventDefinitions().get(0) instanceof ErrorEventDefinition) {
                        processDiagramCanvas.drawErrorEndEvent(flowNode.getName(), graphicInfo, scaleFactor);
                    } else {
                        processDiagramCanvas.drawNoneEndEvent(graphicInfo, scaleFactor);
                    }
                } else {
                    processDiagramCanvas.drawNoneEndEvent(graphicInfo, scaleFactor);
                }

            }
        });
        this.activityDrawInstructions.put(Task.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                processDiagramCanvas.drawTask(flowNode.getName(), graphicInfo);
            }
        });
        this.activityDrawInstructions.put(UserTask.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                processDiagramCanvas.drawUserTask(flowNode.getName(), graphicInfo, scaleFactor);
            }
        });
        this.activityDrawInstructions.put(ScriptTask.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                processDiagramCanvas.drawScriptTask(flowNode.getName(), graphicInfo, scaleFactor);
            }
        });
        this.activityDrawInstructions.put(ServiceTask.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                ServiceTask serviceTask = (ServiceTask)flowNode;
                if ("camel".equalsIgnoreCase(serviceTask.getType())) {
                    processDiagramCanvas.drawCamelTask(serviceTask.getName(), graphicInfo, scaleFactor);
                } else if ("mule".equalsIgnoreCase(serviceTask.getType())) {
                    processDiagramCanvas.drawMuleTask(serviceTask.getName(), graphicInfo, scaleFactor);
                } else {
                    processDiagramCanvas.drawServiceTask(serviceTask.getName(), graphicInfo, scaleFactor);
                }

            }
        });
        this.activityDrawInstructions.put(ReceiveTask.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                processDiagramCanvas.drawReceiveTask(flowNode.getName(), graphicInfo, scaleFactor);
            }
        });
        this.activityDrawInstructions.put(SendTask.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                processDiagramCanvas.drawSendTask(flowNode.getName(), graphicInfo, scaleFactor);
            }
        });
        this.activityDrawInstructions.put(ManualTask.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                processDiagramCanvas.drawManualTask(flowNode.getName(), graphicInfo, scaleFactor);
            }
        });
        this.activityDrawInstructions.put(BusinessRuleTask.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                processDiagramCanvas.drawBusinessRuleTask(flowNode.getName(), graphicInfo, scaleFactor);
            }
        });
        this.activityDrawInstructions.put(ExclusiveGateway.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                processDiagramCanvas.drawExclusiveGateway(graphicInfo, scaleFactor);
            }
        });
        this.activityDrawInstructions.put(InclusiveGateway.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                processDiagramCanvas.drawInclusiveGateway(graphicInfo, scaleFactor);
            }
        });
        this.activityDrawInstructions.put(ParallelGateway.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                processDiagramCanvas.drawParallelGateway(graphicInfo, scaleFactor);
            }
        });
        this.activityDrawInstructions.put(EventGateway.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                processDiagramCanvas.drawEventBasedGateway(graphicInfo, scaleFactor);
            }
        });
        this.activityDrawInstructions.put(BoundaryEvent.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                BoundaryEvent boundaryEvent = (BoundaryEvent)flowNode;
                if (boundaryEvent.getEventDefinitions() != null && !boundaryEvent.getEventDefinitions().isEmpty()) {
                    if (boundaryEvent.getEventDefinitions().get(0) instanceof TimerEventDefinition) {
                        processDiagramCanvas.drawCatchingTimerEvent(flowNode.getName(), graphicInfo, boundaryEvent.isCancelActivity(), scaleFactor);
                    } else if (boundaryEvent.getEventDefinitions().get(0) instanceof ErrorEventDefinition) {
                        processDiagramCanvas.drawCatchingErrorEvent(graphicInfo, boundaryEvent.isCancelActivity(), scaleFactor);
                    } else if (boundaryEvent.getEventDefinitions().get(0) instanceof SignalEventDefinition) {
                        processDiagramCanvas.drawCatchingSignalEvent(flowNode.getName(), graphicInfo, boundaryEvent.isCancelActivity(), scaleFactor);
                    } else if (boundaryEvent.getEventDefinitions().get(0) instanceof MessageEventDefinition) {
                        processDiagramCanvas.drawCatchingMessageEvent(flowNode.getName(), graphicInfo, boundaryEvent.isCancelActivity(), scaleFactor);
                    } else if (boundaryEvent.getEventDefinitions().get(0) instanceof CompensateEventDefinition) {
                        processDiagramCanvas.drawCatchingCompensateEvent(graphicInfo, boundaryEvent.isCancelActivity(), scaleFactor);
                    }
                }

            }
        });
        this.activityDrawInstructions.put(SubProcess.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                if (graphicInfo.getExpanded() != null && !graphicInfo.getExpanded()) {
                    processDiagramCanvas.drawCollapsedSubProcess(flowNode.getName(), graphicInfo, false);
                } else {
                    processDiagramCanvas.drawExpandedSubProcess(flowNode.getName(), graphicInfo, false, scaleFactor);
                }

            }
        });
        this.activityDrawInstructions.put(EventSubProcess.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                if (graphicInfo.getExpanded() != null && !graphicInfo.getExpanded()) {
                    processDiagramCanvas.drawCollapsedSubProcess(flowNode.getName(), graphicInfo, true);
                } else {
                    processDiagramCanvas.drawExpandedSubProcess(flowNode.getName(), graphicInfo, true, scaleFactor);
                }

            }
        });
        this.activityDrawInstructions.put(CallActivity.class, new GrmProcessDiagramGenerator.ActivityDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
                processDiagramCanvas.drawCollapsedCallActivity(flowNode.getName(), graphicInfo);
            }
        });
        this.artifactDrawInstructions.put(TextAnnotation.class, new GrmProcessDiagramGenerator.ArtifactDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, Artifact artifact) {
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(artifact.getId());
                TextAnnotation textAnnotation = (TextAnnotation)artifact;
                processDiagramCanvas.drawTextAnnotation(textAnnotation.getText(), graphicInfo);
            }
        });
        this.artifactDrawInstructions.put(Association.class, new GrmProcessDiagramGenerator.ArtifactDrawInstruction() {
            public void draw(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, Artifact artifact) {
                Association association = (Association)artifact;
                String sourceRef = association.getSourceRef();
                String targetRef = association.getTargetRef();
                BaseElement sourceElement = bpmnModel.getFlowElement(sourceRef);
                BaseElement targetElement = bpmnModel.getFlowElement(targetRef);
                if (sourceElement == null) {
                    sourceElement = bpmnModel.getArtifact(sourceRef);
                }

                if (targetElement == null) {
                    targetElement = bpmnModel.getArtifact(targetRef);
                }

                List<GraphicInfo> graphicInfoList = bpmnModel.getFlowLocationGraphicInfo(artifact.getId());
                graphicInfoList = GrmProcessDiagramGenerator.connectionPerfectionizer(processDiagramCanvas, bpmnModel, (BaseElement)sourceElement, (BaseElement)targetElement, graphicInfoList);
                int[] xPoints = new int[graphicInfoList.size()];
                int[] yPoints = new int[graphicInfoList.size()];

                for(int i = 1; i < graphicInfoList.size(); ++i) {
                    GraphicInfo graphicInfo = (GraphicInfo)graphicInfoList.get(i);
                    GraphicInfo previousGraphicInfo = (GraphicInfo)graphicInfoList.get(i - 1);
                    if (i == 1) {
                        xPoints[0] = (int)previousGraphicInfo.getX();
                        yPoints[0] = (int)previousGraphicInfo.getY();
                    }

                    xPoints[i] = (int)graphicInfo.getX();
                    yPoints[i] = (int)graphicInfo.getY();
                }

                AssociationDirection associationDirection = association.getAssociationDirection();
                processDiagramCanvas.drawAssociation(xPoints, yPoints, associationDirection, false, scaleFactor);
            }
        });
    }

    public InputStream generateDiagram(BpmnModel bpmnModel, String imageType, List<String> highLightedActivities, List<String> highLightedFlows, String activityFontName, String labelFontName, String annotationFontName, ClassLoader customClassLoader, double scaleFactor) {
        return this.generateProcessDiagram(bpmnModel, imageType, highLightedActivities, highLightedFlows, activityFontName, labelFontName, annotationFontName, customClassLoader, scaleFactor).generateImage(imageType);
    }

    public InputStream generateDiagram(BpmnModel bpmnModel, String imageType, List<String> highLightedActivities, List<String> highLightedFlows) {
        return this.generateDiagram(bpmnModel, imageType, highLightedActivities, highLightedFlows, (String)null, (String)null, (String)null, (ClassLoader)null, 1.0D);
    }

    public InputStream generateDiagram(BpmnModel bpmnModel, String imageType, List<String> highLightedActivities, List<String> highLightedFlows, double scaleFactor) {
        return this.generateDiagram(bpmnModel, imageType, highLightedActivities, highLightedFlows, (String)null, (String)null, (String)null, (ClassLoader)null, scaleFactor);
    }

    public InputStream generateDiagram(BpmnModel bpmnModel, String imageType, List<String> highLightedActivities) {
        return this.generateDiagram(bpmnModel, imageType, highLightedActivities, Collections.emptyList());
    }

    public InputStream generateDiagram(BpmnModel bpmnModel, String imageType, List<String> highLightedActivities, double scaleFactor) {
        return this.generateDiagram(bpmnModel, imageType, highLightedActivities, Collections.emptyList(), scaleFactor);
    }

    public InputStream generateDiagram(BpmnModel bpmnModel, String imageType, String activityFontName, String labelFontName, String annotationFontName, ClassLoader customClassLoader) {
        return this.generateDiagram(bpmnModel, imageType, Collections.emptyList(), Collections.emptyList(), activityFontName, labelFontName, annotationFontName, customClassLoader, 1.0D);
    }

    public InputStream generateDiagram(BpmnModel bpmnModel, String imageType, String activityFontName, String labelFontName, String annotationFontName, ClassLoader customClassLoader, double scaleFactor) {
        return this.generateDiagram(bpmnModel, imageType, Collections.emptyList(), Collections.emptyList(), activityFontName, labelFontName, annotationFontName, customClassLoader, scaleFactor);
    }

    public InputStream generatePngDiagram(BpmnModel bpmnModel) {
        return this.generatePngDiagram(bpmnModel, 1.0D);
    }

    public InputStream generatePngDiagram(BpmnModel bpmnModel, double scaleFactor) {
        return this.generateDiagram(bpmnModel, "png", Collections.emptyList(), Collections.emptyList(), scaleFactor);
    }

    public InputStream generateJpgDiagram(BpmnModel bpmnModel) {
        return this.generateJpgDiagram(bpmnModel, 1.0D);
    }

    public InputStream generateJpgDiagram(BpmnModel bpmnModel, double scaleFactor) {
        return this.generateDiagram(bpmnModel, "jpg", Collections.emptyList(), Collections.emptyList());
    }

    public BufferedImage generateImage(BpmnModel bpmnModel, String imageType, List<String> highLightedActivities, List<String> highLightedFlows, String activityFontName, String labelFontName, String annotationFontName, ClassLoader customClassLoader, double scaleFactor) {
        return this.generateProcessDiagram(bpmnModel, imageType, highLightedActivities, highLightedFlows, activityFontName, labelFontName, annotationFontName, customClassLoader, scaleFactor).generateBufferedImage(imageType);
    }

    public BufferedImage generateImage(BpmnModel bpmnModel, String imageType, List<String> highLightedActivities, List<String> highLightedFlows, double scaleFactor) {
        return this.generateImage(bpmnModel, imageType, highLightedActivities, highLightedFlows, (String)null, (String)null, (String)null, (ClassLoader)null, scaleFactor);
    }

    public BufferedImage generatePngImage(BpmnModel bpmnModel, double scaleFactor) {
        return this.generateImage(bpmnModel, "png", Collections.emptyList(), Collections.emptyList(), scaleFactor);
    }

    protected GrmProcessDiagramCanvas generateProcessDiagram(BpmnModel bpmnModel, String imageType, List<String> highLightedActivities, List<String> highLightedFlows, String activityFontName, String labelFontName, String annotationFontName, ClassLoader customClassLoader, double scaleFactor) {
        this.prepareBpmnModel(bpmnModel);
        GrmProcessDiagramCanvas processDiagramCanvas = initProcessDiagramCanvas(bpmnModel, imageType, activityFontName, labelFontName, annotationFontName, customClassLoader);
        Iterator var13 = bpmnModel.getPools().iterator();

        while(var13.hasNext()) {
            Pool pool = (Pool)var13.next();
            GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(pool.getId());
            processDiagramCanvas.drawPoolOrLane(pool.getName(), graphicInfo);
        }

        var13 = bpmnModel.getProcesses().iterator();

        Iterator var15;
        Process process;
        while(var13.hasNext()) {
            process = (Process)var13.next();
            var15 = process.getLanes().iterator();

            while(var15.hasNext()) {
                Lane lane = (Lane)var15.next();
                GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(lane.getId());
                processDiagramCanvas.drawPoolOrLane(lane.getName(), graphicInfo);
            }
        }

        var13 = ((Process)bpmnModel.getProcesses().get(0)).findFlowElementsOfType(FlowNode.class).iterator();

        while(var13.hasNext()) {
            FlowNode flowNode = (FlowNode)var13.next();
            this.drawActivity(processDiagramCanvas, bpmnModel, flowNode, highLightedActivities, highLightedFlows, scaleFactor);
        }

        var13 = bpmnModel.getProcesses().iterator();

        while(var13.hasNext()) {
            process = (Process)var13.next();
            var15 = process.findFlowElementsOfType(FlowNode.class).iterator();

            while(var15.hasNext()) {
                FlowNode flowNode = (FlowNode)var15.next();
                this.drawActivity(processDiagramCanvas, bpmnModel, flowNode, highLightedActivities, highLightedFlows, scaleFactor);
            }
        }

        var13 = bpmnModel.getProcesses().iterator();

        while(true) {
            List subProcesses;
            do {
                if (!var13.hasNext()) {
                    return processDiagramCanvas;
                }

                process = (Process)var13.next();
                var15 = process.getArtifacts().iterator();

                while(var15.hasNext()) {
                    Artifact artifact = (Artifact)var15.next();
                    this.drawArtifact(processDiagramCanvas, bpmnModel, artifact);
                }

                subProcesses = process.findFlowElementsOfType(SubProcess.class, true);
            } while(subProcesses == null);

            Iterator var26 = subProcesses.iterator();

            while(var26.hasNext()) {
                SubProcess subProcess = (SubProcess)var26.next();
                Iterator var18 = subProcess.getArtifacts().iterator();

                while(var18.hasNext()) {
                    Artifact subProcessArtifact = (Artifact)var18.next();
                    this.drawArtifact(processDiagramCanvas, bpmnModel, subProcessArtifact);
                }
            }
        }
    }

    protected void prepareBpmnModel(BpmnModel bpmnModel) {
        List<GraphicInfo> allGraphicInfos = new ArrayList();
        if (bpmnModel.getLocationMap() != null) {
            allGraphicInfos.addAll(bpmnModel.getLocationMap().values());
        }

        if (bpmnModel.getLabelLocationMap() != null) {
            allGraphicInfos.addAll(bpmnModel.getLabelLocationMap().values());
        }

        if (bpmnModel.getFlowLocationMap() != null) {
            Iterator var4 = bpmnModel.getFlowLocationMap().values().iterator();

            while(var4.hasNext()) {
                List<GraphicInfo> flowGraphicInfos = (List)var4.next();
                allGraphicInfos.addAll(flowGraphicInfos);
            }
        }

        if (allGraphicInfos.size() > 0) {
            boolean needsTranslationX = false;
            boolean needsTranslationY = false;
            double lowestX = 0.0D;
            double lowestY = 0.0D;
            Iterator var10 = allGraphicInfos.iterator();

            double translationY;
            while(var10.hasNext()) {
                GraphicInfo graphicInfo = (GraphicInfo)var10.next();
                translationY = graphicInfo.getX();
                double y = graphicInfo.getY();
                if (translationY < lowestX) {
                    needsTranslationX = true;
                    lowestX = translationY;
                }

                if (y < lowestY) {
                    needsTranslationY = true;
                    lowestY = y;
                }
            }

            if (needsTranslationX || needsTranslationY) {
                double translationX = Math.abs(lowestX);
                translationY = Math.abs(lowestY);
                Iterator var14 = allGraphicInfos.iterator();

                while(var14.hasNext()) {
                    GraphicInfo graphicInfo = (GraphicInfo)var14.next();
                    if (needsTranslationX) {
                        graphicInfo.setX(graphicInfo.getX() + translationX);
                    }

                    if (needsTranslationY) {
                        graphicInfo.setY(graphicInfo.getY() + translationY);
                    }
                }
            }
        }

    }

    protected void drawActivity(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, FlowNode flowNode, List<String> highLightedActivities, List<String> highLightedFlows, double scaleFactor) {
        GrmProcessDiagramGenerator.ActivityDrawInstruction drawInstruction = (GrmProcessDiagramGenerator.ActivityDrawInstruction)this.activityDrawInstructions.get(flowNode.getClass());
        boolean highLighted;
        if (drawInstruction != null) {
            drawInstruction.draw(processDiagramCanvas, bpmnModel, flowNode);
            boolean multiInstanceSequential = false;
            boolean multiInstanceParallel = false;
            highLighted = false;
            if (flowNode instanceof Activity) {
                Activity activity = (Activity)flowNode;
                MultiInstanceLoopCharacteristics multiInstanceLoopCharacteristics = activity.getLoopCharacteristics();
                if (multiInstanceLoopCharacteristics != null) {
                    multiInstanceSequential = multiInstanceLoopCharacteristics.isSequential();
                    multiInstanceParallel = !multiInstanceSequential;
                }
            }

            GraphicInfo graphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
            if (!(flowNode instanceof SubProcess)) {
                if (flowNode instanceof CallActivity) {
                    highLighted = true;
                }
            } else {
                highLighted = graphicInfo.getExpanded() != null && !graphicInfo.getExpanded();
            }

            if (scaleFactor == 1.0D) {
                processDiagramCanvas.drawActivityMarkers((int)graphicInfo.getX(), (int)graphicInfo.getY(), (int)graphicInfo.getWidth(), (int)graphicInfo.getHeight(), multiInstanceSequential, multiInstanceParallel, highLighted);
            }

            if (highLightedActivities.contains(flowNode.getId())) {
                drawHighLight(processDiagramCanvas, bpmnModel.getGraphicInfo(flowNode.getId()));
            }
        }

        Iterator var27 = flowNode.getOutgoingFlows().iterator();

        while(var27.hasNext()) {
            SequenceFlow sequenceFlow = (SequenceFlow)var27.next();
            highLighted = highLightedFlows.contains(sequenceFlow.getId());
            String defaultFlow = null;
            if (flowNode instanceof Activity) {
                defaultFlow = ((Activity)flowNode).getDefaultFlow();
            } else if (flowNode instanceof Gateway) {
                defaultFlow = ((Gateway)flowNode).getDefaultFlow();
            }

            boolean isDefault = false;
            if (defaultFlow != null && defaultFlow.equalsIgnoreCase(sequenceFlow.getId())) {
                isDefault = true;
            }

            boolean drawConditionalIndicator = sequenceFlow.getConditionExpression() != null && !(flowNode instanceof Gateway);
            String sourceRef = sequenceFlow.getSourceRef();
            String targetRef = sequenceFlow.getTargetRef();
            FlowElement sourceElement = bpmnModel.getFlowElement(sourceRef);
            FlowElement targetElement = bpmnModel.getFlowElement(targetRef);
            List<GraphicInfo> graphicInfoList = bpmnModel.getFlowLocationGraphicInfo(sequenceFlow.getId());
            if (graphicInfoList != null && graphicInfoList.size() > 0) {
                graphicInfoList = connectionPerfectionizer(processDiagramCanvas, bpmnModel, sourceElement, targetElement, graphicInfoList);
                int[] xPoints = new int[graphicInfoList.size()];
                int[] yPoints = new int[graphicInfoList.size()];

                for(int i = 1; i < graphicInfoList.size(); ++i) {
                    GraphicInfo graphicInfo = (GraphicInfo)graphicInfoList.get(i);
                    GraphicInfo previousGraphicInfo = (GraphicInfo)graphicInfoList.get(i - 1);
                    if (i == 1) {
                        xPoints[0] = (int)previousGraphicInfo.getX();
                        yPoints[0] = (int)previousGraphicInfo.getY();
                    }

                    xPoints[i] = (int)graphicInfo.getX();
                    yPoints[i] = (int)graphicInfo.getY();
                }

                processDiagramCanvas.drawSequenceflow(xPoints, yPoints, drawConditionalIndicator, isDefault, highLighted, scaleFactor);
                GraphicInfo labelGraphicInfo = bpmnModel.getLabelGraphicInfo(sequenceFlow.getId());
                if (labelGraphicInfo != null) {
                    processDiagramCanvas.drawLabel(sequenceFlow.getName(), labelGraphicInfo, false);
                }
            }
        }

        if (flowNode instanceof FlowElementsContainer) {
            var27 = ((FlowElementsContainer)flowNode).getFlowElements().iterator();

            while(var27.hasNext()) {
                FlowElement nestedFlowElement = (FlowElement)var27.next();
                if (nestedFlowElement instanceof FlowNode) {
                    this.drawActivity(processDiagramCanvas, bpmnModel, (FlowNode)nestedFlowElement, highLightedActivities, highLightedFlows, scaleFactor);
                }
            }
        }

    }

    protected static List<GraphicInfo> connectionPerfectionizer(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, BaseElement sourceElement, BaseElement targetElement, List<GraphicInfo> graphicInfoList) {
        GraphicInfo sourceGraphicInfo = bpmnModel.getGraphicInfo(sourceElement.getId());
        GraphicInfo targetGraphicInfo = bpmnModel.getGraphicInfo(targetElement.getId());
        SHAPE_TYPE sourceShapeType = getShapeType(sourceElement);
        SHAPE_TYPE targetShapeType = getShapeType(targetElement);
        return processDiagramCanvas.connectionPerfectionizer(sourceShapeType, targetShapeType, sourceGraphicInfo, targetGraphicInfo, graphicInfoList);
    }

    protected static SHAPE_TYPE getShapeType(BaseElement baseElement) {
        if (!(baseElement instanceof Task) && !(baseElement instanceof Activity) && !(baseElement instanceof TextAnnotation)) {
            if (baseElement instanceof Gateway) {
                return SHAPE_TYPE.Rhombus;
            } else {
                return baseElement instanceof Event ? SHAPE_TYPE.Ellipse : null;
            }
        } else {
            return SHAPE_TYPE.Rectangle;
        }
    }

    protected static GraphicInfo getLineCenter(List<GraphicInfo> graphicInfoList) {
        GraphicInfo gi = new GraphicInfo();
        int[] xPoints = new int[graphicInfoList.size()];
        int[] yPoints = new int[graphicInfoList.size()];
        double length = 0.0D;
        double[] lengths = new double[graphicInfoList.size()];
        lengths[0] = 0.0D;

        int p1;
        GraphicInfo graphicInfo1;
        for(p1 = 1; p1 < graphicInfoList.size(); ++p1) {
            GraphicInfo graphicInfo = (GraphicInfo)graphicInfoList.get(p1);
            graphicInfo1 = (GraphicInfo)graphicInfoList.get(p1 - 1);
            if (p1 == 1) {
                xPoints[0] = (int)graphicInfo1.getX();
                yPoints[0] = (int)graphicInfo1.getY();
            }

            xPoints[p1] = (int)graphicInfo.getX();
            yPoints[p1] = (int)graphicInfo.getY();
            length += Math.sqrt(Math.pow((double)((int)graphicInfo.getX() - (int)graphicInfo1.getX()), 2.0D) + Math.pow((double)((int)graphicInfo.getY() - (int)graphicInfo1.getY()), 2.0D));
            lengths[p1] = length;
        }

        double m = length / 2.0D;
        p1 = 0;
        int p2 = 1;

        for(int i = 1; i < lengths.length; ++i) {
            double len = lengths[i];
            p1 = i - 1;
            p2 = i;
            if (len > m) {
                break;
            }
        }

        graphicInfo1 = (GraphicInfo)graphicInfoList.get(p1);
        GraphicInfo graphicInfo2 = (GraphicInfo)graphicInfoList.get(p2);
        double AB = (double)((int)graphicInfo2.getX() - (int)graphicInfo1.getX());
        double OA = (double)((int)graphicInfo2.getY() - (int)graphicInfo1.getY());
        double OB = lengths[p2] - lengths[p1];
        double ob = m - lengths[p1];
        double ab = AB * ob / OB;
        double oa = OA * ob / OB;
        double mx = graphicInfo1.getX() + ab;
        double my = graphicInfo1.getY() + oa;
        gi.setX(mx);
        gi.setY(my);
        return gi;
    }

    protected void drawArtifact(GrmProcessDiagramCanvas processDiagramCanvas, BpmnModel bpmnModel, Artifact artifact) {
        GrmProcessDiagramGenerator.ArtifactDrawInstruction drawInstruction = (GrmProcessDiagramGenerator.ArtifactDrawInstruction)this.artifactDrawInstructions.get(artifact.getClass());
        if (drawInstruction != null) {
            drawInstruction.draw(processDiagramCanvas, bpmnModel, artifact);
        }

    }

    private static void drawHighLight(GrmProcessDiagramCanvas processDiagramCanvas, GraphicInfo graphicInfo) {
        processDiagramCanvas.drawHighLight((int)graphicInfo.getX(), (int)graphicInfo.getY(), (int)graphicInfo.getWidth(), (int)graphicInfo.getHeight());
    }

    protected static GrmProcessDiagramCanvas initProcessDiagramCanvas(BpmnModel bpmnModel, String imageType, String activityFontName, String labelFontName, String annotationFontName, ClassLoader customClassLoader) {
        double minX = 1.7976931348623157E308D;
        double maxX = 0.0D;
        double minY = 1.7976931348623157E308D;
        double maxY = 0.0D;

        GraphicInfo graphicInfo;
        for(Iterator var15 = bpmnModel.getPools().iterator(); var15.hasNext(); maxY = graphicInfo.getY() + graphicInfo.getHeight()) {
            Pool pool = (Pool)var15.next();
            graphicInfo = bpmnModel.getGraphicInfo(pool.getId());
            minX = graphicInfo.getX();
            maxX = graphicInfo.getX() + graphicInfo.getWidth();
            minY = graphicInfo.getY();
        }

        List<FlowNode> flowNodes = gatherAllFlowNodes(bpmnModel);
        Iterator var26 = flowNodes.iterator();

        GraphicInfo graphicInfo1;
        label148:
        while(var26.hasNext()) {
            FlowNode flowNode = (FlowNode)var26.next();
            GraphicInfo flowNodeGraphicInfo = bpmnModel.getGraphicInfo(flowNode.getId());
            if (flowNodeGraphicInfo.getX() + flowNodeGraphicInfo.getWidth() > maxX) {
                maxX = flowNodeGraphicInfo.getX() + flowNodeGraphicInfo.getWidth();
            }

            if (flowNodeGraphicInfo.getX() < minX) {
                minX = flowNodeGraphicInfo.getX();
            }

            if (flowNodeGraphicInfo.getY() + flowNodeGraphicInfo.getHeight() > maxY) {
                maxY = flowNodeGraphicInfo.getY() + flowNodeGraphicInfo.getHeight();
            }

            if (flowNodeGraphicInfo.getY() < minY) {
                minY = flowNodeGraphicInfo.getY();
            }

            Iterator var19 = flowNode.getOutgoingFlows().iterator();

            while(true) {
                List graphicInfoList;
                do {
                    if (!var19.hasNext()) {
                        continue label148;
                    }

                    SequenceFlow sequenceFlow = (SequenceFlow)var19.next();
                    graphicInfoList = bpmnModel.getFlowLocationGraphicInfo(sequenceFlow.getId());
                } while(graphicInfoList == null);

                Iterator var22 = graphicInfoList.iterator();

                while(var22.hasNext()) {
                    graphicInfo1 = (GraphicInfo)var22.next();
                    if (graphicInfo1.getX() > maxX) {
                        maxX = graphicInfo1.getX();
                    }

                    if (graphicInfo1.getX() < minX) {
                        minX = graphicInfo1.getX();
                    }

                    if (graphicInfo1.getY() > maxY) {
                        maxY = graphicInfo1.getY();
                    }

                    if (graphicInfo1.getY() < minY) {
                        minY = graphicInfo1.getY();
                    }
                }
            }
        }

        List<Artifact> artifacts = gatherAllArtifacts(bpmnModel);
        Iterator var29 = artifacts.iterator();

        while(var29.hasNext()) {
            Artifact artifact = (Artifact)var29.next();
            GraphicInfo artifactGraphicInfo = bpmnModel.getGraphicInfo(artifact.getId());
            if (artifactGraphicInfo != null) {
                if (artifactGraphicInfo.getX() + artifactGraphicInfo.getWidth() > maxX) {
                    maxX = artifactGraphicInfo.getX() + artifactGraphicInfo.getWidth();
                }

                if (artifactGraphicInfo.getX() < minX) {
                    minX = artifactGraphicInfo.getX();
                }

                if (artifactGraphicInfo.getY() + artifactGraphicInfo.getHeight() > maxY) {
                    maxY = artifactGraphicInfo.getY() + artifactGraphicInfo.getHeight();
                }

                if (artifactGraphicInfo.getY() < minY) {
                    minY = artifactGraphicInfo.getY();
                }
            }

            List<GraphicInfo> graphicInfoList = bpmnModel.getFlowLocationGraphicInfo(artifact.getId());
            if (graphicInfoList != null) {
                Iterator var37 = graphicInfoList.iterator();

                while(var37.hasNext()) {
                    GraphicInfo graphicInfo11 = (GraphicInfo)var37.next();
                    if (graphicInfo11.getX() > maxX) {
                        maxX = graphicInfo11.getX();
                    }

                    if (graphicInfo11.getX() < minX) {
                        minX = graphicInfo11.getX();
                    }

                    if (graphicInfo11.getY() > maxY) {
                        maxY = graphicInfo11.getY();
                    }

                    if (graphicInfo11.getY() < minY) {
                        minY = graphicInfo11.getY();
                    }
                }
            }
        }

        int nrOfLanes = 0;
        Iterator var32 = bpmnModel.getProcesses().iterator();

        while(var32.hasNext()) {
            Process process = (Process)var32.next();
            Iterator var36 = process.getLanes().iterator();

            while(var36.hasNext()) {
                Lane l = (Lane)var36.next();
                ++nrOfLanes;
                graphicInfo1 = bpmnModel.getGraphicInfo(l.getId());
                if (graphicInfo1.getX() + graphicInfo1.getWidth() > maxX) {
                    maxX = graphicInfo1.getX() + graphicInfo1.getWidth();
                }

                if (graphicInfo1.getX() < minX) {
                    minX = graphicInfo1.getX();
                }

                if (graphicInfo1.getY() + graphicInfo1.getHeight() > maxY) {
                    maxY = graphicInfo1.getY() + graphicInfo1.getHeight();
                }

                if (graphicInfo1.getY() < minY) {
                    minY = graphicInfo1.getY();
                }
            }
        }

        if (flowNodes.isEmpty() && bpmnModel.getPools().isEmpty() && nrOfLanes == 0) {
            minX = 0.0D;
            minY = 0.0D;
        }

        return new GrmProcessDiagramCanvas((int)maxX + 10, (int)maxY + 10, (int)minX, (int)minY, imageType, activityFontName, labelFontName, annotationFontName, customClassLoader);
    }

    protected static List<Artifact> gatherAllArtifacts(BpmnModel bpmnModel) {
        List<Artifact> artifacts = new ArrayList();
        Iterator var3 = bpmnModel.getProcesses().iterator();

        while(var3.hasNext()) {
            Process process = (Process)var3.next();
            artifacts.addAll(process.getArtifacts());
        }

        return artifacts;
    }

    protected static List<FlowNode> gatherAllFlowNodes(BpmnModel bpmnModel) {
        List<FlowNode> flowNodes = new ArrayList();
        Iterator var3 = bpmnModel.getProcesses().iterator();

        while(var3.hasNext()) {
            Process process = (Process)var3.next();
            flowNodes.addAll(gatherAllFlowNodes((FlowElementsContainer)process));
        }

        return flowNodes;
    }

    protected static List<FlowNode> gatherAllFlowNodes(FlowElementsContainer flowElementsContainer) {
        List<FlowNode> flowNodes = new ArrayList();
        Iterator var3 = flowElementsContainer.getFlowElements().iterator();

        while(var3.hasNext()) {
            FlowElement flowElement = (FlowElement)var3.next();
            if (flowElement instanceof FlowNode) {
                flowNodes.add((FlowNode)flowElement);
            }

            if (flowElement instanceof FlowElementsContainer) {
                flowNodes.addAll(gatherAllFlowNodes((FlowElementsContainer)flowElement));
            }
        }

        return flowNodes;
    }

    public Map<Class<? extends BaseElement>, GrmProcessDiagramGenerator.ActivityDrawInstruction> getActivityDrawInstructions() {
        return this.activityDrawInstructions;
    }

    public void setActivityDrawInstructions(Map<Class<? extends BaseElement>, GrmProcessDiagramGenerator.ActivityDrawInstruction> activityDrawInstructions) {
        this.activityDrawInstructions = activityDrawInstructions;
    }

    public Map<Class<? extends BaseElement>, GrmProcessDiagramGenerator.ArtifactDrawInstruction> getArtifactDrawInstructions() {
        return this.artifactDrawInstructions;
    }

    public void setArtifactDrawInstructions(Map<Class<? extends BaseElement>, GrmProcessDiagramGenerator.ArtifactDrawInstruction> artifactDrawInstructions) {
        this.artifactDrawInstructions = artifactDrawInstructions;
    }

    protected interface ActivityDrawInstruction {
        void draw(GrmProcessDiagramCanvas var1, BpmnModel var2, FlowNode var3);
    }

    protected interface ArtifactDrawInstruction {
        void draw(GrmProcessDiagramCanvas var1, BpmnModel var2, Artifact var3);
    }
}
