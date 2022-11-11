package emu.grasscutter.game.quest.exec;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValueExec;
import emu.grasscutter.game.quest.enums.QuestContent;
import emu.grasscutter.game.quest.enums.QuestExec;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;

import java.util.Arrays;

@QuestValueExec(QuestExec.QUEST_EXEC_ADD_QUEST_PROGRESS)
public class ExecAddQuestProgress extends QuestExecHandler {
    @Override
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        var param = Arrays.stream(paramStr)
            .filter(i -> !i.isBlank())
            .mapToInt(Integer::parseInt)
            .toArray();

        // if quest key do not exists, put param[1] as value
        // otherwise sum 1 to the value linked to key
        quest.getOwner().getQuestProgressCountMap().merge(param[0], param[1], Integer::sum);
        quest.getOwner().getQuestManager().queueEvent(QuestContent.QUEST_CONTENT_ADD_QUEST_PROGRESS, param);

        return true;
    }
}
