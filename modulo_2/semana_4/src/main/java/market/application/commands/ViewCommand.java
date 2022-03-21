package market.application.commands;

import market.application.enums.CrudEnum;
import market.application.enums.TableEnum;

public abstract class ViewCommand {

    private final CrudEnum crudEnum;

    private final TableEnum tableEnum;

    public ViewCommand(CrudEnum crudEnum, TableEnum tableEnum) {
        this.crudEnum = crudEnum;
        this.tableEnum = tableEnum;
    }

    public CrudEnum getCrudEnum() {
        return crudEnum;
    }

    public TableEnum getTableEnum() {
        return tableEnum;
    }

    public abstract void Execute();
}
