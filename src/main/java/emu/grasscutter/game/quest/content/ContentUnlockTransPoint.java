package emu.grasscutter.game.quest.content;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValueContent;

import static emu.grasscutter.game.quest.enums.QuestContent.QUEST_CONTENT_UNLOCK_TRANS_POINT;

@QuestValueContent(QUEST_CONTENT_UNLOCK_TRANS_POINT)
public class ContentUnlockTransPoint extends BaseContent {
    @Override
    public boolean execute(GameQuest quest, QuestData.QuestContentCondition condition, String paramStr, int... params) {
        return condition.getParam()[0] == params[0] && condition.getParam()[1] == params[1];
    }
}
