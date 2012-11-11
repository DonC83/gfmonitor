package org.greyhope.gf.mon.utils;

import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.security.KeyStore;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.X509KeyManager;

/**
 *
 * @author greyhope
 */
public class SecureConnectionKeyManager  implements X509KeyManager  {

   /*
         * The default PKIX X509KeyManager.  We'll delegate
         * decisions to it, and fall back to the logic in this class if the
         * default X509KeyManager doesn't trust it.
         */
        X509KeyManager pkixKeyManager;

        public SecureConnectionKeyManager(String keyStore, char[] password) throws Exception {
            this(new File(keyStore), password);
        }

        public SecureConnectionKeyManager(File keyStore, char[] password) throws Exception {
            // create a "default" JSSE X509KeyManager.

            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(new FileInputStream(keyStore), password);

            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509", "SunJSSE");
            kmf.init(ks, password);

            KeyManager kms[] = kmf.getKeyManagers();

            /*
             * Iterate over the returned keymanagers, look
             * for an instance of X509KeyManager.  If found,
             * use that as our "default" key manager.
             */
            for (int i = 0; i < kms.length; i++) {
                if (kms[i] instanceof X509KeyManager) {
                    pkixKeyManager = (X509KeyManager) kms[i];
                    return;
                }
            }

            /*
             * Find some other way to initialize, or else we have to fail the
             * constructor.
             */
            throw new Exception("Couldn't initialize");
        }

    @Override
        public PrivateKey getPrivateKey(String arg0) {
            return pkixKeyManager.getPrivateKey(arg0);
        }

    @Override
        public X509Certificate[] getCertificateChain(String arg0) {
            return pkixKeyManager.getCertificateChain(arg0);
        }

    @Override
        public String[] getClientAliases(String arg0, Principal[] arg1) {
            return pkixKeyManager.getClientAliases(arg0, arg1);
        }

    @Override
        public String chooseClientAlias(String[] arg0, Principal[] arg1, Socket arg2) {
            return pkixKeyManager.chooseClientAlias(arg0, arg1, arg2);
        }

    @Override
        public String[] getServerAliases(String arg0, Principal[] arg1) {
            return pkixKeyManager.getServerAliases(arg0, arg1);
        }

    @Override
        public String chooseServerAlias(String arg0, Principal[] arg1, Socket arg2) {
            return pkixKeyManager.chooseServerAlias(arg0, arg1, arg2);
        }
    
}
