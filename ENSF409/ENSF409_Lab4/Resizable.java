/**
 * Interface in order to change size of shapes
 * @author Brenden Bickner
 * @version 1.0
 * @since 2017-02-12
 */
public interface Resizable {
    static final double LIMIT = 1.0;
    public void shrink(double factor) throws SizeFactorException;
    public void enlarge(double factor) throws SizeFactorException;
}