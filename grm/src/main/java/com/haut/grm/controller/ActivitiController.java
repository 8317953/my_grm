/*     */ package com.haut.grm.controller;
/*     */ 
/*     */ import com.haut.grm.model.meta.User;
import com.haut.grm.repository.meta.UserRepository;
/*     */ import com.haut.grm.repository.type.MedicineTypeRepository;
/*     */ import com.haut.grm.service.AuthUserService;
/*     */ import com.haut.grm.service.BusinessService;
/*     */ import io.swagger.annotations.ApiParam;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.activiti.engine.ActivitiIllegalArgumentException;
/*     */ import org.activiti.engine.ActivitiObjectNotFoundException;
/*     */ import org.activiti.engine.FormService;
/*     */ import org.activiti.engine.HistoryService;
/*     */ import org.activiti.engine.IdentityService;
/*     */ import org.activiti.engine.ManagementService;
/*     */ import org.activiti.engine.RepositoryService;
/*     */ import org.activiti.engine.RuntimeService;
/*     */ import org.activiti.engine.TaskService;
/*     */ import org.activiti.engine.form.FormData;
/*     */ import org.activiti.engine.form.FormProperty;
/*     */ import org.activiti.engine.form.FormType;
/*     */ import org.activiti.engine.form.StartFormData;
/*     */ import org.activiti.engine.form.TaskFormData;
/*     */ import org.activiti.engine.history.HistoricVariableInstance;
/*     */ import org.activiti.engine.history.HistoricVariableInstanceQuery;
/*     */ import org.activiti.engine.repository.ProcessDefinition;
/*     */ import org.activiti.engine.runtime.ProcessInstance;
/*     */ import org.activiti.engine.runtime.ProcessInstanceBuilder;
/*     */ import org.activiti.engine.task.Task;
/*     */ import org.activiti.rest.service.api.RestResponseFactory;
/*     */ import org.activiti.rest.service.api.RestUrlBuilder;
/*     */ import org.activiti.rest.service.api.RestUrls;
/*     */ import org.activiti.rest.service.api.engine.variable.RestVariable;
/*     */ import org.activiti.rest.service.api.form.FormDataResponse;
/*     */ import org.activiti.rest.service.api.form.RestEnumFormProperty;
/*     */ import org.activiti.rest.service.api.form.RestFormProperty;
/*     */ import org.activiti.rest.service.api.runtime.process.ProcessInstanceCreateRequest;
/*     */ import org.activiti.rest.service.api.runtime.process.ProcessInstanceResponse;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.format.annotation.DateTimeFormat;
/*     */ import org.springframework.format.annotation.DateTimeFormat.ISO;
/*     */ import org.springframework.http.HttpStatus;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ public class ActivitiController
/*     */ {
	
	@Autowired
	private UserRepository userRepo;
	
	
/*     */   @Autowired
/*     */   RepositoryService repositoryService;
/*     */   @Autowired
/*     */   RuntimeService runtimeService;
/*     */   @Autowired
/*     */   TaskService taskService;
/*     */   @Autowired
/*     */   HistoryService historyService;
/*     */   @Autowired
/*     */   IdentityService identityService;
/*     */   @Autowired
/*     */   FormService formService;
/*     */   @Autowired
/*     */   ManagementService managementService;
/*     */   @Autowired
/*     */   BusinessService businessService;
/*     */   @Autowired
/*     */   MedicineTypeRepository mtRepo;
/*     */   @Autowired
/*     */   protected RestResponseFactory restResponseFactory;
/*     */   


//{processDefinitionId: "myworkload:4:605004", businessKey: "Q1606553197664"}
//businessKey
//:
//"Q1606553197664"
//processDefinitionId
//:
//"myworkload:4:605004"


/*     */   @RequestMapping(value={"/activiti/start_process"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ProcessInstanceResponse startProcess(@RequestBody ProcessInstanceCreateRequest request, HttpServletRequest httpRequest, HttpServletResponse response)
/*     */   {
				
	
				//正常的如上注释  businessKey  和processDefinitionId  前面这些就是在判断这个
/*  88 */     if ((request.getProcessDefinitionId() == null) && (request.getProcessDefinitionKey() == null) && (request.getMessage() == null)) {
/*  89 */       throw new ActivitiIllegalArgumentException("Either processDefinitionId, processDefinitionKey or message is required.");
/*     */     }
/*     */     
/*  92 */     int paramsSet = (request.getProcessDefinitionId() != null ? 1 : 0) + (request.getProcessDefinitionKey() != null ? 1 : 0) + (request.getMessage() != null ? 1 : 0);
/*     */     
/*  94 */     if (paramsSet > 1) {
/*  95 */       throw new ActivitiIllegalArgumentException("Only one of processDefinitionId, processDefinitionKey or message should be set.");
/*     */     }
/*     */     
/*  98 */     if (request.isTenantSet())
/*     */     {
/* 100 */       if (request.getProcessDefinitionId() != null) {
/* 101 */         throw new ActivitiIllegalArgumentException("TenantId can only be used with either processDefinitionKey or message.");
/*     */       }
/*     */     }
/*     */     

			

/* 105 */     Map<String, Object> startVariables = null;
/* 106 */     if (request.getVariables() != null) {
/* 107 */       startVariables = new HashMap();
/* 108 */       for (RestVariable variable : request.getVariables()) {
/* 109 */         if (variable.getName() == null) {
/* 110 */           throw new ActivitiIllegalArgumentException("Variable name is required.");
/*     */         }
				System.out.println(variable.getName());
/* 112 */         startVariables.put(variable.getName(), this.restResponseFactory.getVariableValue(variable));
/*     */       }
/*     */     }
/*     */     
/* 116 */     Map<String, Object> transientVariables = null;
/* 117 */     if (request.getTransientVariables() != null) {
/* 118 */       transientVariables = new HashMap();
/* 119 */       for (RestVariable variable : request.getTransientVariables()) {
/* 120 */         if (variable.getName() == null) {
/* 121 */           throw new ActivitiIllegalArgumentException("Variable name is required.");
/*     */         }
					System.out.println(variable.getName());
/* 123 */         transientVariables.put(variable.getName(), this.restResponseFactory.getVariableValue(variable));
/*     */       }
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 129 */       ProcessInstance instance = null;
/*     */       
/* 131 */       ProcessInstanceBuilder processInstanceBuilder = this.runtimeService.createProcessInstanceBuilder();//创建进程任务
/* 132 */       if (request.getProcessDefinitionId() != null) {
/* 133 */         processInstanceBuilder.processDefinitionId(request.getProcessDefinitionId());//设置id
/*     */       }
/* 135 */       if (request.getProcessDefinitionKey() != null) {
/* 136 */         processInstanceBuilder.processDefinitionKey(request.getProcessDefinitionKey());//设置key
/*     */       }
/* 138 */       if (request.getMessage() != null) {
	System.out.println(request.getMessage());
/* 139 */         processInstanceBuilder.messageName(request.getMessage());//设置name
/*     */       }
/* 141 */       if (request.getBusinessKey() != null) {
/* 142 */         processInstanceBuilder.businessKey(request.getBusinessKey());//设置businesskey
/*     */       }
/* 144 */       if (request.isTenantSet()) {
/* 145 */         processInstanceBuilder.tenantId(request.getTenantId());
/*     */       }
/* 147 */       if (startVariables != null) {
/* 148 */         processInstanceBuilder.variables(startVariables);
/*     */       }
/* 150 */       if (transientVariables != null) {
/* 151 */         processInstanceBuilder.transientVariables(transientVariables);
/*     */       }
/*     */       
/* 154 */       this.identityService.setAuthenticatedUserId(AuthUserService.getCurrentUser(userRepo).getUsername());//注入发起人这一点很重要  注入发起人  这也是  如何知道返回给谁重新填写表单
/* 155 */       instance = processInstanceBuilder.start();//开始流程
/*     */       
/* 157 */       response.setStatus(HttpStatus.CREATED.value());
/*     */       



//for (Map.Entry<String, Object> entry : this.runtimeService.getVariables(instance.getId())) {
//	  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//	}






/* 159 */       if (request.getReturnVariables()) {
/* 160 */         Map<String, Object> runtimeVariableMap = null;
/* 161 */         List<HistoricVariableInstance> historicVariableList = null;
/* 162 */         if (instance.isEnded()) {
/* 163 */           historicVariableList = this.historyService.createHistoricVariableInstanceQuery().processInstanceId(instance.getId()).list();
/*     */         } else {
/* 165 */           runtimeVariableMap = this.runtimeService.getVariables(instance.getId());
/*     */         }
/* 167 */         return this.restResponseFactory.createProcessInstanceResponse(instance, true, runtimeVariableMap, historicVariableList);
/*     */       }
/*     */       
/* 170 */       return this.restResponseFactory.createProcessInstanceResponse(instance);
/*     */     }
/*     */     catch (ActivitiObjectNotFoundException aonfe)
/*     */     {
/* 174 */       throw new ActivitiIllegalArgumentException(aonfe.getMessage(), aonfe);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @RequestMapping(value={"/activiti/form/form-data"}, method={org.springframework.web.bind.annotation.RequestMethod.GET}, produces={"application/json"})
/*     */   public FormDataResponse getFormData(@RequestParam(value="taskId", required=false) String taskId, @ApiParam(name="processDefinitionId", value="The process definition id corresponding to the start event form data that needs to be retrieved.") @RequestParam(value="processDefinitionId", required=false) String processDefinitionId, HttpServletRequest request)
/*     */   {
/* 182 */     if ((taskId == null) && (processDefinitionId == null)) {
/* 183 */       throw new ActivitiIllegalArgumentException("The taskId or processDefinitionId parameter has to be provided");
/*     */     }
/*     */     
/* 186 */     if ((taskId != null) && (processDefinitionId != null)) {
/* 187 */       throw new ActivitiIllegalArgumentException("Not both a taskId and a processDefinitionId parameter can be provided");
/*     */     }
/*     */     
/* 190 */     FormData formData = null;
/* 191 */     String id = null;
/* 192 */     if (taskId != null) {
/* 193 */       formData = this.formService.getTaskFormData(taskId);
/* 194 */       id = taskId;
/*     */     } else {
/* 196 */       formData = this.formService.getStartFormData(processDefinitionId);
/* 197 */       id = processDefinitionId;
/*     */     }
/*     */     
/* 200 */     if (formData == null) {
/* 201 */       throw new ActivitiObjectNotFoundException("Could not find a form data with id '" + id + "'.", FormData.class);
/*     */     }
/*     */     
/* 204 */     FormDataResponse result = new FormDataResponse();
/* 205 */     result.setDeploymentId(formData.getDeploymentId());
/* 206 */     result.setFormKey(formData.getFormKey());
/* 207 */     if (formData.getFormProperties() != null) {
/* 208 */       for (FormProperty formProp : formData.getFormProperties()) {
/* 209 */         RestFormProperty restFormProp = new RestFormProperty();
/* 210 */         restFormProp.setId(formProp.getId());
/* 211 */         restFormProp.setName(formProp.getName());
/* 212 */         if (formProp.getType() != null) {
/* 213 */           restFormProp.setType(formProp.getType().getName());
/*     */         }
/* 215 */         restFormProp.setValue(formProp.getValue());
/* 216 */         restFormProp.setReadable(formProp.isReadable());
/* 217 */         restFormProp.setRequired(formProp.isRequired());
/* 218 */         restFormProp.setWritable(formProp.isWritable());
/* 219 */         if ("enum".equals(restFormProp.getType())) {
/* 220 */           Object values = formProp.getType().getInformation("values");
/* 221 */           if (values != null)
/*     */           {
/* 223 */             Map<String, String> enumValues = (Map)values;
/* 224 */             for (String enumId : enumValues.keySet()) {
/* 225 */               RestEnumFormProperty enumProperty = new RestEnumFormProperty();
/* 226 */               enumProperty.setId(enumId);
/* 227 */               enumProperty.setName((String)enumValues.get(enumId));
/* 228 */               restFormProp.addEnumValue(enumProperty);
/*     */             }
/*     */           }
/*     */         }
/* 232 */         else if ("type".equals(restFormProp.getType())) {
/* 233 */           Object values = formProp.getType().getInformation("values");
/* 234 */           if (values != null)
/*     */           {
/* 236 */             Map<String, String> enumValues = (Map)values;
/* 237 */             for (String enumId : enumValues.keySet()) {
/* 238 */               RestEnumFormProperty enumProperty = new RestEnumFormProperty();
/* 239 */               enumProperty.setId(enumId);
/* 240 */               enumProperty.setName((String)enumValues.get(enumId));
/* 241 */               restFormProp.addEnumValue(enumProperty);
/*     */             }
/*     */           }
/* 244 */         } else if ("date".equals(restFormProp.getType())) {
/* 245 */           restFormProp.setDatePattern((String)formProp.getType().getInformation("datePattern"));
/*     */         }
/* 247 */         result.addFormProperty(restFormProp);
/*     */       }
/*     */     }
/* 250 */     RestUrlBuilder urlBuilder = RestUrlBuilder.fromCurrentRequest();
/* 251 */     if ((formData instanceof StartFormData)) {
/* 252 */       StartFormData startFormData = (StartFormData)formData;
/* 253 */       if (startFormData.getProcessDefinition() != null) {
/* 254 */         result.setProcessDefinitionId(startFormData.getProcessDefinition().getId());
/* 255 */         result.setProcessDefinitionUrl(urlBuilder.buildUrl(RestUrls.URL_PROCESS_DEFINITION, new Object[] { startFormData.getProcessDefinition().getId() }));
/*     */       }
/* 257 */     } else if ((formData instanceof TaskFormData)) {
/* 258 */       TaskFormData taskFormData = (TaskFormData)formData;
/* 259 */       if (taskFormData.getTask() != null) {
/* 260 */         result.setTaskId(taskFormData.getTask().getId());
/* 261 */         result.setTaskUrl(urlBuilder.buildUrl(RestUrls.URL_TASK, new Object[] { taskFormData.getTask().getId() }));
/*     */       }
/*     */     }
/* 264 */     return result;
/*     */   }
/*     */   
/*     */ 
@RequestMapping(value={"/mybusiness/available_key"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
public String getKey()
{
	return "Q"+new Date().getTime();
}

@RequestMapping(value={"/business/available_key"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
public String getKey(@RequestParam String formatter, @RequestParam(required=false) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date time)
{
  if (time == null) {
    return this.businessService.getBusinessKeyForPattern(formatter);
  }
  return this.businessService.getBusinessKeyForPattern(formatter, time);
}





/*     */   
/*     */ 
/*     */   @RequestMapping(value={"/business/available_sc_key"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String getKeyForSC(@RequestParam String formatter, @RequestParam(required=false) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date time)
/*     */   {
/* 281 */     if (time == null) {
/* 282 */       return this.businessService.getBusinessKeyForSc(formatter);
/*     */     }
/* 284 */     return this.businessService.getBusinessKeyForSc(formatter, time);
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\controller\ActivitiController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */