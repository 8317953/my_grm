
  // IntelliJ API Decompiler stub source generated from a class file
  // Implementation of methods is not available

package com.haut.grm.json.view;

public class Views {
    public Views() { /* compiled code */ }

    public static interface ActivitiGroupView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface AlertMessageView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface AnalysisForDataTablesView extends com.haut.grm.json.view.Views.AnalysisView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface AnalysisLevelView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface AnalysisTypeView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface AnalysisView extends com.haut.grm.json.view.Views.IdView, com.haut.grm.json.view.Views.AnalysisLevelView, com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface BalanceSheetForDataTablesView extends com.haut.grm.json.view.Views.BalanceSheetView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface BalanceSheetView extends com.haut.grm.json.view.Views.IdView, com.haut.grm.json.view.Views.CreaterView {
    }

    public static interface BaseStandardCodeView extends com.haut.grm.json.view.Views.IdView {
    }

    
    public static interface MyBaseNameView extends BaseStandardCodeView,BaseTypeView{}
    
    public static interface BaseTypeView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface BriefView extends com.haut.grm.json.view.Views.UpdaterView {
    }

    public static interface BusinessNotificationView extends com.haut.grm.json.view.Views.IdView, com.haut.grm.json.view.Views.UserView, com.haut.grm.json.view.Views.RoleView {
    }

    public static interface CameraManufacturerView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface CameraTypeView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface CardForDataTablesView extends com.haut.grm.json.view.Views.CardView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface CardTypeView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface CardView extends com.haut.grm.json.view.Views.IdView, com.haut.grm.json.view.Views.CardTypeView {
    }

    public static interface CargoRefCompartmentView extends com.haut.grm.json.view.Views.CompartmentView {
    }

    public static interface CargoStatusView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface CargoView extends com.haut.grm.json.view.Views.SpaceStatusView, com.haut.grm.json.view.Views.SpaceConditionView {
    }

    public static interface MyDateJsView extends com.haut.grm.json.view.Views.CargoView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }
    
   
    
    public static interface CargoWithCompartmentView extends com.haut.grm.json.view.Views.CompartmentView, com.haut.grm.json.view.Views.CargoRefCompartmentView {
    }

    public static interface CargoWithStoreView extends com.haut.grm.json.view.Views.CompartmentWithStoreView, com.haut.grm.json.view.Views.CargoWithCompartmentView {
    }

    public static interface ClientForDataTablesView extends com.haut.grm.json.view.Views.ClientView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface ClientRefContractView {
    }

    public static interface ClientView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface ClientWithContractsView extends com.haut.grm.json.view.Views.ClientView, com.haut.grm.json.view.Views.ClientRefContractView {
    }

    public static interface CompanyTypeView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface CompartmentRefCargoView extends com.haut.grm.json.view.Views.CargoView {
    }

    public static interface CompartmentRefStoreView extends com.haut.grm.json.view.Views.StoreVerboseView {
    }

    public static interface CompartmentView extends com.haut.grm.json.view.Views.SpaceStatusView, com.haut.grm.json.view.Views.SpaceConditionView {
    }

    public static interface CompartmentWithCargoView extends com.haut.grm.json.view.Views.CompartmentView, com.haut.grm.json.view.Views.CompartmentRefCargoView {
    }

    public static interface CompartmentWithStoreView extends com.haut.grm.json.view.Views.CompartmentView, com.haut.grm.json.view.Views.CompartmentRefStoreView {
    }

    public static interface ContractEntryView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface ContractForDataTablesView extends com.haut.grm.json.view.Views.ContractWithGrainPlanAndClientView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface ContractRefClientView extends com.haut.grm.json.view.Views.ClientView {
    }

    public static interface ContractRefGrainPlanView extends com.haut.grm.json.view.Views.GrainPlanView {
    }

    public static interface ContractTypeView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface ContractVerboseView extends com.haut.grm.json.view.Views.ContractWithClientView, com.haut.grm.json.view.Views.ContractWithGrainPlanView {
    }

    public static interface ContractView extends com.haut.grm.json.view.Views.IdView, com.haut.grm.json.view.Views.ContractTypeView, com.haut.grm.json.view.Views.UserView, com.haut.grm.json.view.Views.ContractEntryView {
    }

    public static interface ContractWithClientView extends com.haut.grm.json.view.Views.ContractRefClientView, com.haut.grm.json.view.Views.ContractView {
    }

    public static interface ContractWithGrainPlanAndClientView extends com.haut.grm.json.view.Views.ContractWithClientView, com.haut.grm.json.view.Views.ContractWithGrainPlanView {
    }

    public static interface ContractWithGrainPlanView extends com.haut.grm.json.view.Views.ContractRefGrainPlanView, com.haut.grm.json.view.Views.ContractView {
    }

    public static interface CoreVersionView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface CreaterView extends com.haut.grm.json.view.Views.UserView {
    }

    public static interface DeductRecordForDataTablesView extends com.haut.grm.json.view.Views.DeductRecordView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface DeductRecordView extends com.haut.grm.json.view.Views.StoreView, com.haut.grm.json.view.Views.IdView, com.haut.grm.json.view.Views.CreaterView {
    }

    public static interface DeductRuleForDataTablesView extends com.haut.grm.json.view.Views.DeductRuleView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface DeductRuleView extends com.haut.grm.json.view.Views.AnalysisLevelView, com.haut.grm.json.view.Views.AnalysisTypeView, com.haut.grm.json.view.Views.IdView {
    }

    public static interface DepartmentView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface DepotView extends com.haut.grm.json.view.Views.UpdaterView {
    }

    public static interface DeviceCameraForDataTablesView extends com.haut.grm.json.view.Views.DeviceCameraView, com.haut.grm.json.view.Views.DeviceCameraRefStoreView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface DeviceCameraRefStoreView {
    }

    public static interface DeviceCameraView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface DeviceGsmModemView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface DoorCollectForDataTablesView extends com.haut.grm.json.view.Views.DoorCollectWithStoreView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface DoorCollectRefStoreView extends com.haut.grm.json.view.Views.StoreView {
    }

    public static interface DoorCollectView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface DoorCollectWithStoreView extends com.haut.grm.json.view.Views.DoorCollectRefStoreView, com.haut.grm.json.view.Views.DoorCollectView {
    }

    public static interface DoorRefEntryDoorView extends com.haut.grm.json.view.Views.EntryDoorView {
    }

    public static interface DoorRefStoreView extends com.haut.grm.json.view.Views.StoreView {
    }

    public static interface DoorView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface DoorWithEntryDoorsView extends com.haut.grm.json.view.Views.DoorRefEntryDoorView {
    }

    public static interface DoorWithStoreView extends com.haut.grm.json.view.Views.DoorView, com.haut.grm.json.view.Views.DoorRefStoreView {
    }

    public static interface EntryDoorForDataTablesView extends com.haut.grm.json.view.Views.EntryDoorWithStoreView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface EntryDoorRefDoorView extends com.haut.grm.json.view.Views.DoorView {
    }

    public static interface EntryDoorView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface EntryDoorWithDoorView extends com.haut.grm.json.view.Views.EntryDoorRefDoorView, com.haut.grm.json.view.Views.EntryDoorView {
    }

    public static interface EntryDoorWithStoreView extends com.haut.grm.json.view.Views.EntryDoorWithDoorView, com.haut.grm.json.view.Views.DoorWithStoreView {
    }

    public static interface EntryMeasureForDataTablesView extends com.haut.grm.json.view.Views.EntryMeasureWithStoreView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface EntryMeasureRefStoreView extends com.haut.grm.json.view.Views.StoreVerboseView {
    }

    public static interface EntryMeasureView extends com.haut.grm.json.view.Views.StorageLoadView, com.haut.grm.json.view.Views.UserView, com.haut.grm.json.view.Views.IdView {
    }

    public static interface EntryMeasureWithStoreView extends com.haut.grm.json.view.Views.EntryMeasureRefStoreView, com.haut.grm.json.view.Views.EntryMeasureView {
    }

    public static interface EntrySafetyForDataTablesView extends com.haut.grm.json.view.Views.EntrySafetyWithStoreView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface EntrySafetyRefStoreView extends com.haut.grm.json.view.Views.StoreView {
    }

    public static interface EntrySafetyView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface EntrySafetyWithStoreView extends com.haut.grm.json.view.Views.EntrySafetyRefStoreView, com.haut.grm.json.view.Views.EntrySafetyView {
    }

    public static interface EntryTemperatureForDataTablesView extends com.haut.grm.json.view.Views.EntryTemperatureWithStoreView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface EntryTemperatureRefStoreView extends com.haut.grm.json.view.Views.StoreVerboseView {
    }

    public static interface EntryTemperatureView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface EntryTemperatureWithStoreView extends com.haut.grm.json.view.Views.EntryTemperatureRefStoreView, com.haut.grm.json.view.Views.EntryTemperatureView {
    }

    public static interface EthnicityView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface GlobalConfigurationView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface GrainPlanForDataTablesView extends com.haut.grm.json.view.Views.GrainPlanWithStoreView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface GrainPlanRefContractView {
    }

    public static interface GrainPlanRefStoreView {
    }

    public static interface GrainPlanView extends com.haut.grm.json.view.Views.GrainVarietyView, com.haut.grm.json.view.Views.PlanTypeView, com.haut.grm.json.view.Views.IdView {
    }

    public static interface GrainPlanWithContractView extends com.haut.grm.json.view.Views.GrainPlanRefContractView, com.haut.grm.json.view.Views.ContractView, com.haut.grm.json.view.Views.GrainPlanView {
    }

    public static interface GrainPlanWithStoreShortView extends com.haut.grm.json.view.Views.GrainPlanView, com.haut.grm.json.view.Views.GrainPlanRefStoreView {
    }

    public static interface GrainPlanWithStoreView extends com.haut.grm.json.view.Views.GrainPlanView, com.haut.grm.json.view.Views.GrainPlanRefStoreView, com.haut.grm.json.view.Views.StoreView {
    }

    public static interface GrainSourceTypeView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface GrainStorageForDataTablesView extends com.haut.grm.json.view.Views.GrainStorageView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface GrainStorageView extends com.haut.grm.json.view.Views.IdView, com.haut.grm.json.view.Views.StoreView, com.haut.grm.json.view.Views.GrainVarietyView, com.haut.grm.json.view.Views.CreaterView, com.haut.grm.json.view.Views.StorageLoadView {
    }

    public static interface GrainTrafficDetailedView extends com.haut.grm.json.view.Views.GrainTrafficView, com.haut.grm.json.view.Views.ContractWithGrainPlanAndClientView {
    }

    public static interface GrainTrafficForDataTablesView extends com.haut.grm.json.view.Views.GrainTrafficDetailedView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface GrainTrafficView extends com.haut.grm.json.view.Views.IdView, com.haut.grm.json.view.Views.PackageTypeView, com.haut.grm.json.view.Views.TrafficTypeView, com.haut.grm.json.view.Views.AnalysisView, com.haut.grm.json.view.Views.RegisterRecordView, com.haut.grm.json.view.Views.StageView, com.haut.grm.json.view.Views.WeightSheetView, com.haut.grm.json.view.Views.BalanceSheetView {
    }

    public static interface GrainTypeView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface GrainVarietyView extends com.haut.grm.json.view.Views.BaseStandardCodeView {
    }

    public static interface IdView {
    }

    public static interface LocationView extends com.haut.grm.json.view.Views.BaseStandardCodeView {
    }

    public static interface MeasureDiffForDataTablesView extends com.haut.grm.json.view.Views.MeasureDiffWithStoreView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface MeasureDiffRefStoreView extends com.haut.grm.json.view.Views.StoreView {
    }

    public static interface MeasureDiffView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface MeasureDiffWithStoreView extends com.haut.grm.json.view.Views.MeasureDiffRefStoreView, com.haut.grm.json.view.Views.MeasureDiffView {
    }

    public static interface MedicineTypeView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface MenuRefParentView {
    }

    public static interface MenuRefSubView {
    }

    public static interface MenuView extends com.haut.grm.json.view.Views.SystemModuleView, com.haut.grm.json.view.Views.IdView {
    }

    public static interface MenuWithParentView extends com.haut.grm.json.view.Views.MenuView, com.haut.grm.json.view.Views.MenuRefParentView {
    }

    public static interface MenuWithSubView extends com.haut.grm.json.view.Views.MenuView, com.haut.grm.json.view.Views.MenuRefSubView {
    }

    public static interface PackageCategoryView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface PackageTypeView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface PlanTypeView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface RegisterRecordForDataTablesView extends com.haut.grm.json.view.Views.RegisterRecordView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface RegisterRecordView extends com.haut.grm.json.view.Views.VehicleTrafficView, com.haut.grm.json.view.Views.IdView {
    }

    public static interface RoleRefMenuView extends com.haut.grm.json.view.Views.MenuWithParentView {
    }

    public static interface RoleRefSystemTrafficModuleView extends com.haut.grm.json.view.Views.SystemTrafficModuleView {
    }

    public static interface RoleVerboseView extends com.haut.grm.json.view.Views.RoleWithTrafficModuleView, com.haut.grm.json.view.Views.RoleWithMenuView {
    }

    public static interface RoleView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface RoleWithMenuView extends com.haut.grm.json.view.Views.RoleView, com.haut.grm.json.view.Views.RoleRefMenuView {
    }

    public static interface RoleWithTrafficModuleView extends com.haut.grm.json.view.Views.RoleView, com.haut.grm.json.view.Views.RoleRefSystemTrafficModuleView {
    }

    public static interface ScaleView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface SmsTemplateView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface SourceTypeView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface SpaceConditionView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface SpaceStatusView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface StageView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface StorageLoadView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface StoreConfigRefStoreView extends com.haut.grm.json.view.Views.StoreView {
    }

    public static interface StoreConfigView extends com.haut.grm.json.view.Views.StoreTypeView, com.haut.grm.json.view.Views.StoreModelView, com.haut.grm.json.view.Views.StoreManagerView, com.haut.grm.json.view.Views.IdView {
    }

    public static interface StoreConfigWithStoreView extends com.haut.grm.json.view.Views.StoreConfigRefStoreView, com.haut.grm.json.view.Views.StoreConfigView {
    }

    public static interface StoreManagerView extends com.haut.grm.json.view.Views.UserView {
    }

    public static interface StoreModelView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface StoreRefCompartmentView extends com.haut.grm.json.view.Views.CompartmentView {
    }

    public static interface StoreRefConfigView extends com.haut.grm.json.view.Views.StoreConfigView {
    }

    public static interface StoreRefDepotView extends com.haut.grm.json.view.Views.DepotView {
    }

    public static interface StoreRefDeviceCameraView extends com.haut.grm.json.view.Views.DeviceCameraView {
    }

    public static interface StoreRefDoorView extends com.haut.grm.json.view.Views.DoorView {
    }

    public static interface StoreRefStatusView extends com.haut.grm.json.view.Views.StoreStatusView {
    }

    public static interface StoreStatusRefStoreView extends com.haut.grm.json.view.Views.StoreView {
    }

    public static interface StoreStatusView extends com.haut.grm.json.view.Views.SpaceConditionView, com.haut.grm.json.view.Views.SpaceStatusView, com.haut.grm.json.view.Views.IdView {
    }

    public static interface StoreStatusWithStoreView extends com.haut.grm.json.view.Views.StoreStatusRefStoreView, com.haut.grm.json.view.Views.StoreStatusView {
    }

    public static interface StoreTypeView extends com.haut.grm.json.view.Views.BaseStandardCodeView {
    }

    public static interface StoreVerboseView extends com.haut.grm.json.view.Views.StoreWithDeviceCameraView, com.haut.grm.json.view.Views.StoreWithConfigView, com.haut.grm.json.view.Views.StoreWithStatusView, com.haut.grm.json.view.Views.StoreWithDoorsView, com.haut.grm.json.view.Views.StoreView {
    }

    public static interface StoreView extends com.haut.grm.json.view.Views.IdView {
    }
    
    
    
    
    
    
    
    
    
    
    public static interface StoreTemWaterEntryView extends com.haut.grm.json.view.Views.IdView {
    }
    public static interface StoreTemWaterEntryToStoreView extends com.haut.grm.json.view.Views.StoreTemWaterEntryView,com.haut.grm.json.view.Views.StoreView{
    }
    public static interface StoreTemWaterEntryToTfPlaneView extends com.haut.grm.json.view.Views.StoreTemWaterEntryView,com.haut.grm.json.view.Views.SdTfPlaneView{
    }
    public static interface StoreTemWaterEntryToTfPlaneAndStoreView extends com.haut.grm.json.view.Views.StoreTemWaterEntryToTfPlaneView,com.haut.grm.json.view.Views.StoreTemWaterEntryToStoreView{
    }
    
    
    
    
    public static interface SdTfPlaneView extends com.haut.grm.json.view.Views.BaseTypeView{
    }
    public static interface SdTfPlaneToEntryView extends com.haut.grm.json.view.Views.SdTfPlaneView, com.haut.grm.json.view.Views.StoreTemWaterEntryToStoreView{
    }
    public static interface DataSdTfPlaneToEntryView extends com.haut.grm.json.view.Views.SdTfPlaneToEntryView,org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View{
    }
    
    
    
    
    
    
    public static interface SdTfDateView extends com.haut.grm.json.view.Views.BaseTypeView{
    }
    
    
    public static interface SdTfDateToStoreView  extends com.haut.grm.json.view.Views.SdTfDateView,com.haut.grm.json.view.Views.StoreView{
    }
    
    public static interface SdTfDateToTfPlaneView  extends com.haut.grm.json.view.Views.SdTfDateView,com.haut.grm.json.view.Views.SdTfPlaneView{
    }
    
    public static interface SdTfDateToTfPlaneAndStoreView  extends com.haut.grm.json.view.Views.SdTfDateToTfPlaneView,com.haut.grm.json.view.Views.SdTfDateToStoreView{
    }
    public static interface DataSdTfDateToTfPlaneAndStoreView  extends com.haut.grm.json.view.Views.SdTfDateToTfPlaneAndStoreView,org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View{
    }
    
    
    
    
    
    
    
    
    public static interface StoreWithCargoView extends com.haut.grm.json.view.Views.StoreWithCompartmentView, com.haut.grm.json.view.Views.CompartmentWithCargoView {
    }

    public static interface StoreWithCompartmentView extends com.haut.grm.json.view.Views.StoreRefCompartmentView, com.haut.grm.json.view.Views.StoreVerboseView {
    }

    public static interface StoreWithConfigView extends com.haut.grm.json.view.Views.StoreView, com.haut.grm.json.view.Views.StoreRefConfigView {
    }

    public static interface StoreWithDeviceCameraView extends com.haut.grm.json.view.Views.StoreView, com.haut.grm.json.view.Views.StoreRefDeviceCameraView {
    }

    public static interface StoreWithDoorsView extends com.haut.grm.json.view.Views.StoreRefDoorView, com.haut.grm.json.view.Views.StoreView {
    }

    public static interface StoreWithStatusView extends com.haut.grm.json.view.Views.StoreView, com.haut.grm.json.view.Views.StoreRefStatusView {
    }

    public static interface SystemLogForDataTablesView extends com.haut.grm.json.view.Views.SystemlogView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface SystemModuleView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface SystemStatusView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface SystemTrafficModuleView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface SystemVariableForDataTablesView extends org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View, com.haut.grm.json.view.Views.SystemVariableView {
    }

    public static interface SystemVariableView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface SystemlogView extends com.haut.grm.json.view.Views.UserView {
    }

    public static interface TrafficTypeView extends com.haut.grm.json.view.Views.BaseTypeView {
    }

    public static interface UpdaterView extends com.haut.grm.json.view.Views.UserView {
    }

    public static interface UserRefRoleView extends com.haut.grm.json.view.Views.RoleView {
    }

    public static interface UserView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface UserWithRoleView extends com.haut.grm.json.view.Views.UserView, com.haut.grm.json.view.Views.UserRefRoleView {
    }

    public static interface VehicleTrafficForDatatableView extends com.haut.grm.json.view.Views.VehicleTrafficView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface VehicleTrafficImageView extends com.haut.grm.json.view.Views.VehicleTrafficView {
    }

    public static interface VehicleTrafficView extends com.haut.grm.json.view.Views.IdView, com.haut.grm.json.view.Views.ContractView, com.haut.grm.json.view.Views.DeviceCameraView {
    }

    public static interface WeightSheetForDataTablesView extends com.haut.grm.json.view.Views.WeightSheetView, org.springframework.data.jpa.datatables.mapping.DataTablesOutput.View {
    }

    public static interface WeightSheetView extends com.haut.grm.json.view.Views.UserView, com.haut.grm.json.view.Views.IdView, com.haut.grm.json.view.Views.StoreView, com.haut.grm.json.view.Views.CargoView {
    }

    public static interface WorkLoadCategoryView extends com.haut.grm.json.view.Views.IdView {
    }

    public static interface WorkloadScheduleView extends com.haut.grm.json.view.Views.WorkLoadCategoryView {
    }

    public static interface WorkloadTypeView extends com.haut.grm.json.view.Views.BaseTypeView {
    }
    
    public static interface PlaneView extends com.haut.grm.json.view.Views.BaseTypeView, com.haut.grm.json.view.Views.BaseStandardCodeView{
    }
    
    
    
    
//    tfsb
    
    
    
    public static interface TfToStoreView extends com.haut.grm.json.view.Views.BaseTypeView, com.haut.grm.json.view.Views.StoreView{
    }
    
    
    
    
    
    
    public static interface TfEquipStatusToEquipView extends com.haut.grm.json.view.Views.BaseTypeView{
    }
    
    

    public static interface TfEquipToStatusView extends com.haut.grm.json.view.Views.BaseTypeView{
    }
    
    
    public static interface TfEquipToStatusAndStoreView extends com.haut.grm.json.view.Views.TfEquipToStatusView,com.haut.grm.json.view.Views.TfToStoreView{
    }
    
    
    
    
    
}