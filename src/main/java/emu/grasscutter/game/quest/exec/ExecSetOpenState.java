package emu.grasscutter.game.quest.exec;

import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValueExec;
import emu.grasscutter.game.quest.enums.QuestExec;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;

import java.util.Arrays;

@QuestValueExec(QuestExec.QUEST_EXEC_SET_OPEN_STATE)
public class ExecSetOpenState extends QuestExecHandler {
    @Override
    public boolean execute(GameQuest quest, QuestData.QuestExecParam condition, String... paramStr) {
        var param = Arrays.stream(paramStr)
            .filter(i -> !i.isBlank())
            .mapToInt(Integer::parseInt)
            .toArray();

        // not sure if allow client check is necessary in setOpenStateFromClient
        // since the client unlikely will request states that it isn't allowed to unlock
        quest.getOwner().getProgressManager().setOpenStateFromClient(param[0], param[1]);
        return true;
    }
}
