/*******************************************************************************
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package org.worldgrower;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.worldgrower.actions.UTestActions;
import org.worldgrower.actions.UTestAttackUtils;
import org.worldgrower.actions.UTestBecomeLeaderCandidateAction;
import org.worldgrower.actions.UTestBuildArenaAction;
import org.worldgrower.actions.UTestBuildHouseAction;
import org.worldgrower.actions.UTestBuildInnAction;
import org.worldgrower.actions.UTestBuildJailAction;
import org.worldgrower.actions.UTestBuildLibraryAction;
import org.worldgrower.actions.UTestBuildPaperMillAction;
import org.worldgrower.actions.UTestBuildSacrificialAltarAction;
import org.worldgrower.actions.UTestBuildShackAction;
import org.worldgrower.actions.UTestBuildShrineAction;
import org.worldgrower.actions.UTestBuildSmithAction;
import org.worldgrower.actions.UTestBuildWellAction;
import org.worldgrower.actions.UTestBuyAction;
import org.worldgrower.actions.UTestCatchFishAction;
import org.worldgrower.actions.UTestChooseProfessionAction;
import org.worldgrower.actions.UTestCollectWaterAction;
import org.worldgrower.actions.UTestConstructTrainingDummyAction;
import org.worldgrower.actions.UTestCraftIronAxeAction;
import org.worldgrower.actions.UTestCraftIronBootsAction;
import org.worldgrower.actions.UTestCraftIronClaymoreAction;
import org.worldgrower.actions.UTestCraftIronCuirassAction;
import org.worldgrower.actions.UTestCraftIronGauntletsAction;
import org.worldgrower.actions.UTestCraftIronGreataxeAction;
import org.worldgrower.actions.UTestCraftIronGreatswordAction;
import org.worldgrower.actions.UTestCraftIronGreavesAction;
import org.worldgrower.actions.UTestCraftIronShieldAction;
import org.worldgrower.actions.UTestCraftLongBowAction;
import org.worldgrower.actions.UTestCraftRepairHammerAction;
import org.worldgrower.actions.UTestCraftUtils;
import org.worldgrower.actions.UTestCreateGraveAction;
import org.worldgrower.actions.UTestCreateHumanMeatAction;
import org.worldgrower.actions.UTestCutWoodAction;
import org.worldgrower.actions.UTestDonateMoneyAction;
import org.worldgrower.actions.UTestDrinkAction;
import org.worldgrower.actions.UTestDrinkFromInventoryAction;
import org.worldgrower.actions.UTestEatAction;
import org.worldgrower.actions.UTestEatFromInventoryAction;
import org.worldgrower.actions.UTestEatNightShadeAction;
import org.worldgrower.actions.UTestExtractOilAction;
import org.worldgrower.actions.UTestGetItemFromInventoryAction;
import org.worldgrower.actions.UTestHarvestFoodAction;
import org.worldgrower.actions.UTestHarvestGrapesAction;
import org.worldgrower.actions.UTestHarvestNightShadeAction;
import org.worldgrower.actions.UTestMineGoldAction;
import org.worldgrower.actions.UTestMineOreAction;
import org.worldgrower.actions.UTestMineSoulGemsAction;
import org.worldgrower.actions.UTestMineStoneAction;
import org.worldgrower.actions.UTestOrganizationNamer;
import org.worldgrower.actions.UTestPlantBerryBushAction;
import org.worldgrower.actions.UTestPlantGrapeVineAction;
import org.worldgrower.actions.UTestPutItemInInventoryAction;
import org.worldgrower.actions.UTestRepairEquipmentInInventoryAction;
import org.worldgrower.actions.UTestSellAction;
import org.worldgrower.actions.UTestSetLegalActionsAction;
import org.worldgrower.actions.UTestSleepAction;
import org.worldgrower.actions.UTestStartOrganizationVoteAction;
import org.worldgrower.actions.UTestStealAction;
import org.worldgrower.actions.UTestTalkAction;
import org.worldgrower.actions.UTestVoteForLeaderAction;
import org.worldgrower.actions.UTestVotingPropertyUtils;
import org.worldgrower.actions.magic.UTestAnimateDeadAction;
import org.worldgrower.actions.magic.UTestAnimateSuitOfArmorAction;
import org.worldgrower.actions.magic.UTestBurdenAction;
import org.worldgrower.actions.magic.UTestCureDiseaseAction;
import org.worldgrower.actions.magic.UTestDetectMagicAction;
import org.worldgrower.actions.magic.UTestDetectPoisonAndDiseaseAction;
import org.worldgrower.actions.magic.UTestDisintegrateArmorAction;
import org.worldgrower.actions.magic.UTestDisintegrateWeaponAction;
import org.worldgrower.actions.magic.UTestDispelMagicAction;
import org.worldgrower.actions.magic.UTestEnlargeAction;
import org.worldgrower.actions.magic.UTestFeatherAction;
import org.worldgrower.actions.magic.UTestFireBoltAttackAction;
import org.worldgrower.actions.magic.UTestInflictWoundsAction;
import org.worldgrower.actions.magic.UTestInvisibilityAction;
import org.worldgrower.actions.magic.UTestLightningBoltAttackAction;
import org.worldgrower.actions.magic.UTestLockMagicSpellAction;
import org.worldgrower.actions.magic.UTestMendAction;
import org.worldgrower.actions.magic.UTestRayOfFrostAttackAction;
import org.worldgrower.actions.magic.UTestReduceAction;
import org.worldgrower.actions.magic.UTestResearchSpellAction;
import org.worldgrower.actions.magic.UTestSilenceMagicAction;
import org.worldgrower.actions.magic.UTestSleepMagicAction;
import org.worldgrower.actions.magic.UTestSoulTrapAction;
import org.worldgrower.actions.magic.UTestUnlockMagicSpellAction;
import org.worldgrower.actions.magic.UTestWaterWalkAction;
import org.worldgrower.attribute.UTestIdList;
import org.worldgrower.attribute.UTestIdMap;
import org.worldgrower.attribute.UTestIntProperty;
import org.worldgrower.attribute.UTestItemCountMap;
import org.worldgrower.attribute.UTestKnowledgeMap;
import org.worldgrower.attribute.UTestPropertyCountMap;
import org.worldgrower.attribute.UTestSkillUtils;
import org.worldgrower.attribute.UTestWorldObjectProperties;
import org.worldgrower.condition.UTestConditions;
import org.worldgrower.conversation.UTestArenaFighterPayCheckConversation;
import org.worldgrower.conversation.UTestAskGoalConversation;
import org.worldgrower.conversation.UTestBecomeArenaFighterConversation;
import org.worldgrower.conversation.UTestBrawlConversation;
import org.worldgrower.conversation.UTestBuyHouseConversation;
import org.worldgrower.conversation.UTestCollectTaxesConversation;
import org.worldgrower.conversation.UTestComplimentConversation;
import org.worldgrower.conversation.UTestConversations;
import org.worldgrower.conversation.UTestCurePoisonConversation;
import org.worldgrower.conversation.UTestDeityFollowersConversation;
import org.worldgrower.conversation.UTestDeityReasonConversation;
import org.worldgrower.conversation.UTestDemandMoneyConversation;
import org.worldgrower.conversation.UTestDemandsConversation;
import org.worldgrower.conversation.UTestFamilyConversation;
import org.worldgrower.conversation.UTestGiveFoodConversation;
import org.worldgrower.conversation.UTestImmediateGoalConversation;
import org.worldgrower.conversation.UTestIntimidateConversation;
import org.worldgrower.conversation.UTestJoinPerformerOrganizationConversation;
import org.worldgrower.conversation.UTestJoinTargetOrganizationConversation;
import org.worldgrower.conversation.UTestKissConversation;
import org.worldgrower.conversation.UTestLearnSkillUsingOrganizationConversation;
import org.worldgrower.conversation.UTestLocationConversation;
import org.worldgrower.conversation.UTestLookTheSameConversation;
import org.worldgrower.conversation.UTestMergeOrganizationsConversation;
import org.worldgrower.conversation.UTestMinorHealConversation;
import org.worldgrower.conversation.UTestNicerConversation;
import org.worldgrower.conversation.UTestNotNicerConversation;
import org.worldgrower.conversation.UTestOrganizationConversation;
import org.worldgrower.conversation.UTestProfessionPractitionersConversation;
import org.worldgrower.conversation.UTestProfessionReasonConversation;
import org.worldgrower.conversation.UTestProposeMateConversation;
import org.worldgrower.conversation.UTestRelationshipConversation;
import org.worldgrower.conversation.UTestSawDisguisingConversation;
import org.worldgrower.conversation.UTestSellHouseConversation;
import org.worldgrower.conversation.UTestSetOrganizationProfitPercentageConversation;
import org.worldgrower.conversation.UTestShareKnowledgeConversation;
import org.worldgrower.conversation.UTestStartArenaFightConversation;
import org.worldgrower.conversation.UTestStopSellingConversation;
import org.worldgrower.conversation.UTestSwitchDeityConversation;
import org.worldgrower.conversation.UTestVoteLeaderOrganizationConversation;
import org.worldgrower.conversation.UTestWhoIsLeaderOrganizationConversation;
import org.worldgrower.conversation.UTestWhyAngryConversation;
import org.worldgrower.conversation.UTestWhyAngryOtherConversation;
import org.worldgrower.conversation.UTestWhyNotIntelligentConversation;
import org.worldgrower.deity.UTestDeityPropertyUtils;
import org.worldgrower.generator.UTestBeastOnTurn;
import org.worldgrower.generator.UTestBerryBushOnTurn;
import org.worldgrower.generator.UTestBuildingGenerator;
import org.worldgrower.generator.UTestCommonerGenerator;
import org.worldgrower.generator.UTestCommonerOnTurn;
import org.worldgrower.generator.UTestCowOnTurn;
import org.worldgrower.generator.UTestCreatureGenerator;
import org.worldgrower.generator.UTestFishOnTurn;
import org.worldgrower.generator.UTestIllusionOnTurn;
import org.worldgrower.generator.UTestNightShadeOnTurn;
import org.worldgrower.generator.UTestPlantOnTurn;
import org.worldgrower.generator.UTestSkeletonEvaluationFunction;
import org.worldgrower.generator.UTestVotingOnTurn;
import org.worldgrower.goal.*;
import org.worldgrower.history.UTestHistoryImpl;
import org.worldgrower.util.UTestNumberUtils;

@RunWith(Suite.class)
@SuiteClasses({ 
	UTestBackgroundImpl.class, 
	UTestCreaturePositionCondition.class, 
	UTestTaskCalculator.class, 
	UTestTalkAction.class,
	UTestChooseProfessionAction.class,
	UTestGoalUtils.class,
	UTestGoalCalculator.class,
	UTestZone.class,
	UTestReach.class,
	UTestBuildLocationUtils.class,
	UTestWorldGenerator.class,
	UTestWorldObjectContainer.class,
	UTestConversations.class,
	UTestDungeonMaster.class,
	UTestGoalChangedCalculator.class,
	UTestWorldImpl.class,
	UTestIdMap.class,
	UTestWorldObjectProperties.class,
	UTestIdList.class,
	UTestHistoryImpl.class,
	UTestLocationConversation.class,
	UTestPropertyCountMap.class,
	UTestIntProperty.class,
	UTestNumberUtils.class,
	UTestAttackUtils.class,
	UTestGroupPropertyUtils.class,
	UTestSkillUtils.class,
	UTestAbstractScribeSpellsGoal.class,
	UTestKnowledgeMap.class,
	UTestDemandsConversation.class,
	UTestWorldObjectImpl.class,
	UTestConditions.class,
	UTestDefaultGoalObstructedHandler.class,
	UTestWorldFacade.class,
	UTestBuySellUtils.class,
	UTestHousePropertyUtils.class,
	UTestArenaPropertyUtils.class,
	UTestSocializeGoal.class,
	UTestLocationUtils.class,
	UTestArmorPropertyUtils.class,
	UTestMeleeDamagePropertyUtils.class,
	UTestCraftUtils.class,
	UTestVotingPropertyUtils.class,
	UTestFacadeUtils.class,
	UTestBrawlPropertyUtils.class,
	UTestRelationshipPropertyUtils.class,
	UTestDrownUtils.class,
	UTestWeightPropertyUtils.class,
	UTestInventoryPropertyUtils.class,
	UTestRacePropertyUtils.class,
	UTestLegalActionsPropertyUtils.class,
	UTestLockUtils.class,
	UTestOrganizationNamer.class,
	UTestWhoIsLeaderOrganizationConversation.class,
	UTestDemandMoneyConversation.class,
	UTestComplimentConversation.class,
	UTestProfessionPractitionersConversation.class,
	UTestDeityFollowersConversation.class,
	UTestShareKnowledgeConversation.class,
	UTestFamilyConversation.class,
	UTestWhyAngryOtherConversation.class,
	UTestWhyAngryConversation.class,
	UTestBrawlConversation.class,
	UTestMinorHealConversation.class,
	UTestSetOrganizationProfitPercentageConversation.class,
	UTestJoinPerformerOrganizationConversation.class,
	UTestCreatureGenerator.class,
	UTestArenaFighterPayCheckConversation.class,
	UTestJoinTargetOrganizationConversation.class,
	UTestGiveFoodConversation.class,
	UTestSellHouseConversation.class,
	UTestNicerConversation.class,
	UTestCurePoisonConversation.class,
	UTestIntimidateConversation.class,
	UTestStartArenaFightConversation.class,
	UTestDeityReasonConversation.class,
	UTestOrganizationConversation.class,
	UTestImmediateGoalConversation.class,
	UTestBecomeArenaFighterConversation.class,
	UTestProposeMateConversation.class,
	UTestBuyClothesGoal.class,
	UTestBuyHouseConversation.class,
	UTestCollectTaxesConversation.class,
	UTestVoteLeaderOrganizationConversation.class,
	UTestRelationshipConversation.class,
	UTestProfessionReasonConversation.class,
	UTestDeityPropertyUtils.class,
	UTestCommonerGenerator.class,
	UTestWhyNotIntelligentConversation.class,
	UTestActions.class,
	UTestKissConversation.class,
	UTestLearnSkillUsingOrganizationConversation.class,
	UTestLookTheSameConversation.class,
	UTestNotNicerConversation.class,
	UTestOperationInfo.class,
	UTestSawDisguisingConversation.class,
	UTestSacrificePeopleToDeityGoal.class,
	UTestProtectOneSelfGoal.class,
	UTestChildrenGoal.class,
	UTestMineResourceGoal.class,
	UTestCraftEquipmentGoal.class,
	UTestCottonGoal.class,
	UTestMateGoal.class,
	UTestEquipmentGoal.class,
	UTestWeaveClothesGoal.class,
	UTestGetPoisonCuredGoal.class,
	UTestShrineToDeityGoal.class,
	UTestDrinkWaterGoal.class,
	UTestCollectWaterGoal.class,
	UTestGhoulGoal.class,
	UTestImproveRelationshipGoal.class,
	UTestFishingPoleGoal.class,
	UTestFurnitureGoal.class,
	UTestGetHealedGoal.class,
	UTestFoodGoal.class,
	UTestGatherFoodGoal.class,
	UTestCreateFoodSourcesGoal.class,
	UTestRecruitProfessionOrganizationMembersGoal.class,
	UTestSubdueOutsidersGoal.class,
	UTestCaptureCriminalsGoal.class,
	UTestTrainGoal.class,
	UTestCreateWineGoal.class,
	UTestHealOthersGoal.class,
	UTestLibraryGoal.class,
	UTestPaperMillGoal.class,
	UTestSmithGoal.class,
	UTestFeedOthersGoal.class,
	UTestCreateHouseGoal.class,
	UTestSexGoal.class,
	UTestMarkFoodAsSellableGoal.class,
	UTestStartOrganizationVoteGoal.class,
	UTestOrganizationCandidateGoal.class,
	UTestShackGoal.class,
	UTestOrganizationVoteGoal.class,
	UTestKillVillagersGoal.class,
	UTestHuntUndeadGoal.class,
	UTestCreateFurnitureGoal.class,
	UTestPaperGoal.class,
	UTestMintGoldGoal.class,
	UTestCreateGraveGoal.class,
	UTestDestroyShrinesToOtherDeitiesGoal.class,
	UTestLearnSkillGoal.class,
	UTestCreateOrPlantWoodGoal.class,
	UTestDeathReasonPropertyUtils.class,
	UTestVampireBiteGoal.class,
	UTestRestGoal.class,
	UTestArenaGoal.class,
	UTestJailGoal.class,
	UTestGatherRemainsGoal.class,
	UTestMineGoldGoal.class,
	UTestScribeWizardSpellsGoal.class,
	UTestCatchFishGoal.class,
	UTestCollectArenaRewardGoal.class,
	UTestSetTaxesGoal.class,
	UTestFightInArenaGoal.class,
	UTestArenaFightGoal.class,
	UTestBrawlGoal.class,
	UTestSellWoodGoal.class,
	UTestDonateMoneyToArenaGoal.class,
	UTestBecomeReligionOrganizationMemberGoal.class,
	UTestBecomeProfessionsOrganizationMemberGoal.class,
	UTestResearchMagicSkillsKnowledgeGoal.class,
	UTestKillOutsidersGoal.class,
	UTestChooseDeityGoal.class,
	UTestCocoonOutsidersGoal.class,
	UTestReleaseCapturedCriminalsGoal.class,
	UTestHouseGoal.class,
	UTestMarkHouseAsSellableGoal.class,
	UTestOffspringGoal.class,
	UTestHandoverTaxesGoal.class,
	UTestCollectPayCheckGoal.class,
	UTestCollectTaxesGoal.class,
	UTestCommonerOnTurn.class,
	UTestCowOnTurn.class,
	UTestFishOnTurn.class,
	UTestVotingOnTurn.class,
	UTestPlantOnTurn.class,
	UTestSkeletonEvaluationFunction.class,
	UTestIllusionOnTurn.class,
	UTestNightShadeOnTurn.class,
	UTestBerryBushOnTurn.class,
	UTestWaterPropertyUtils.class,
	UTestSellHouseGoal.class,
	UTestRevengeGoal.class,
	UTestChooseProfessionGoal.class,
	UTestCreatePaperGoal.class,
	UTestCreatePoisonGoal.class,
	UTestPregnancyPropertyUtils.class,
	UTestSwitchDeityConversation.class,
	UTestItemCountMap.class,
	UTestBeastOnTurn.class,
	UTestBuildingGenerator.class,
	UTestBuildHouseAction.class,
	UTestBuildShackAction.class,
	UTestDrinkAction.class,
	UTestDrinkFromInventoryAction.class,
	UTestBuyAction.class,
	UTestSellAction.class,
	UTestSleepAction.class,
	UTestCollectWaterAction.class,
	UTestStealAction.class,
	UTestEatNightShadeAction.class,
	UTestSetLegalActionsAction.class,
	UTestBuildWellAction.class,
	UTestBuildShrineAction.class,
	UTestBuildArenaAction.class,
	UTestBuildInnAction.class,
	UTestBuildSacrificialAltarAction.class,
	UTestBuildJailAction.class,
	UTestBuildPaperMillAction.class,
	UTestCreateGraveAction.class,
	UTestConstructTrainingDummyAction.class,
	UTestEatAction.class,
	UTestBuildSmithAction.class,
	UTestBuildLibraryAction.class,
	UTestPlantBerryBushAction.class,
	UTestMineOreAction.class,
	UTestMineStoneAction.class,
	UTestMineSoulGemsAction.class,
	UTestCutWoodAction.class,
	UTestHarvestFoodAction.class,
	UTestHarvestGrapesAction.class,
	UTestRepairEquipmentInInventoryAction.class,
	UTestMergeOrganizationsConversation.class,
	UTestAskGoalConversation.class,
	UTestStopSellingConversation.class,
	UTestEatFromInventoryAction.class,
	UTestPlantGrapeVineAction.class,
	UTestDonateMoneyAction.class,
	UTestHarvestNightShadeAction.class,
	UTestMineGoldAction.class,
	UTestCatchFishAction.class,
	UTestExtractOilAction.class,
	UTestPutItemInInventoryAction.class,
	UTestGetItemFromInventoryAction.class,
	UTestReduceAction.class,
	UTestEnlargeAction.class,
	UTestMendAction.class,
	UTestBurdenAction.class,
	UTestFeatherAction.class,
	UTestDisintegrateArmorAction.class,
	UTestDisintegrateWeaponAction.class,
	UTestDispelMagicAction.class,
	UTestFireBoltAttackAction.class,
	UTestInflictWoundsAction.class,
	UTestRayOfFrostAttackAction.class,
	UTestSilenceMagicAction.class,
	UTestSleepMagicAction.class,
	UTestWaterWalkAction.class,
	UTestInvisibilityAction.class,
	UTestSoulTrapAction.class,
	UTestCureDiseaseAction.class,
	UTestLockMagicSpellAction.class,
	UTestUnlockMagicSpellAction.class,
	UTestLightningBoltAttackAction.class,
	UTestAnimateSuitOfArmorAction.class,
	UTestResearchSpellAction.class,
	UTestAnimateDeadAction.class,
	UTestDetectPoisonAndDiseaseAction.class,
	UTestDetectMagicAction.class,
	UTestVoteForLeaderAction.class,
	UTestBecomeLeaderCandidateAction.class,
	UTestStartOrganizationVoteAction.class,
	UTestCraftIronAxeAction.class,
	UTestCraftIronCuirassAction.class,
	UTestCraftIronBootsAction.class,
	UTestCraftIronClaymoreAction.class,
	UTestCraftIronGauntletsAction.class,
	UTestCraftIronGreavesAction.class,
	UTestCraftIronShieldAction.class,
	UTestCraftIronGreataxeAction.class,
	UTestCraftIronGreatswordAction.class,
	UTestCraftLongBowAction.class,
	UTestCraftRepairHammerAction.class,
	UTestCreateHumanMeatAction.class
})
public class CompleteTestSuite {
}
