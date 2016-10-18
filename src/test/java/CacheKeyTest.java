import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CacheKeyTest {

    private CacheKey cacheKey;

    @Before
    public void setUp() throws Exception {
        cacheKey = new CacheKey();
    }

    @Test
    public void should_GenerateKey() throws Exception {

        assertThat(cacheKey.generateKey("com.email.dao.Repository26", "saveProduct13"), is("DBO$com.email.dao.Repository26.saveProduct13"));
        assertThat(cacheKey.generateKey("com.email.dao.Repository26", "saveLooooongProduct21"), is("DBO$Repository26.saveLooooongProduct21"));
        assertThat(cacheKey.generateKey("com.email.dao.LoooooooooooogRepository40", "saveLooooongProduct21"), is("DBO$saveLooooongProduct21"));
        assertThat(cacheKey.generateKey("com.email.dao.LoooooooooooogRepository40", "saveLooooooooooooooooooooooooooooooongProduct47"), is("DBO$saveLooooooooooooooooooooooooooooooongProduc.~"));
    }

//    @Test
//    public void should_GenerateKey2() {
//        new keyFunctor("com.email.dao.Repository26", "saveProduct13")
//                .fmap()
//    }
}