package infrastructure;

public interface IUnitOfWork {

    void commit();

    void rollback();
}