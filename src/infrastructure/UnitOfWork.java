package infrastructure;

public class UnitOfWork implements IUnitOfWork {

    private DatabaseContext db;

    public UnitOfWork(DatabaseContext db) {
        this.db = db;
    }

    @Override
    public void commit() {
        System.out.println("Transacción confirmada (commit)");
    }

    @Override
    public void rollback() {
        System.out.println("Transacción revertida (rollback)");
    }
}