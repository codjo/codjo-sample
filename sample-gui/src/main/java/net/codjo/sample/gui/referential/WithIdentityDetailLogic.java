package net.codjo.sample.gui.referential;
import net.codjo.mad.client.request.RequestException;
import net.codjo.mad.gui.framework.AbstractDetailGui;
import net.codjo.mad.gui.framework.AbstractDetailLogic;
import net.codjo.mad.gui.request.DetailDataSource;
/**
 *
 */
public class WithIdentityDetailLogic extends AbstractDetailLogic {
    public WithIdentityDetailLogic(DetailDataSource dataSource)
          throws RequestException {
        this(dataSource, new WithIdentityDetailGui());
    }


    public WithIdentityDetailLogic(DetailDataSource dataSource, AbstractDetailGui newGui)
          throws RequestException {
        super(dataSource, newGui);
    }
}
