package ARS;

import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;



/**
 * Custom login module that adds another PublicCredential to the subject
 */
@SuppressWarnings("unchecked")
public class CustomHashtableLoginModule implements LoginModule {

  protected Map<String, ?> _sharedState;
  protected Map<String, ?> _options;

/**
 * Initialization of login module
 */
  public void initialize(
    Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
      _sharedState = sharedState;
      _options = options;
  }

  public boolean login() throws LoginException {
    try {
      java.util.Hashtable<String, Object> customProperties = (java.util.Hashtable<String, Object>) 
        _sharedState.get(AttributeNameConstants.WSCREDENTIAL_PROPERTIES_KEY);
      if (customProperties == null) {
        customProperties = new java.util.Hashtable<String, Object>();
      }

      customProperties.put(AttributeNameConstants.WSCREDENTIAL_USERID, "userId");
      // Sample of creating custom cache key
      customProperties.put(AttributeNameConstants.WSCREDENTIAL_CACHE_KEY, "customCacheKey");

      /*
       * Sample for creating user ID and security name
       * customProperties.put(AttributeNameConstants.WSCREDENTIAL_UNIQUEID, "userId");
       * customProperties.put(AttributeNameConstants.WSCREDENTIAL_SECURITYNAME, "securityName");
       * customProperties.put(AttributeNameConstants.WSCREDENTIAL_REALM, "realm");
       * customProperties.put(AttributeNameConstants.WSCREDENTIAL_GROUPS, "groupList");
       */
      /*
       * Sample for creating user ID and password
       * customProperties.put(AttributeNameConstants.WSCREDENTIAL_USERID, "userId");
       * customProperties.put(AttributeNameConstants.WSCREDENTIAL_PASSWORD, "password");
       */
      Map<String, java.util.Hashtable> mySharedState = (Map<String, java.util.Hashtable>) _sharedState;
      mySharedState.put(AttributeNameConstants.WSCREDENTIAL_PROPERTIES_KEY, customProperties);
    } catch (Exception e) {
        throw new LoginException("LoginException: " + e.getMessage());
    }

    return true;
  }

  public boolean commit() throws LoginException {
    return true;
  }

  public boolean abort() {
    return true;
  }

  public boolean logout() {
    return true;
  }
}

  public boolean login() throws LoginException {
    try {
      AccessController.doPrivileged(new PrivilegedExceptionAction<Object>() {
        public Object run() throws Exception {
          _subject.getPrivateCredentials().add(customPrivateCredential);
          return null;
        }

      });
    } catch (PrivilegedActionException e) {
      throw new LoginException(e.getLocalizedMessage());
    }

    String username = null;
    char passwordChar[] = null;
    byte[] credToken = null;
    HttpServletRequest request = null;
    HttpServletResponse response = null;
    Map appContext = null;
    String realm = null;
    String authMechOid = null;
    java.security.cert.X509Certificate[] certChain = null;

    NameCallback nameCallback = null;
    PasswordCallback passwordCallback = null;
    WSCredTokenCallbackImpl wsCredTokenCallback = null;
    WSServletRequestCallback wsServletRequestCallback = null;
    WSServletResponseCallback wsServletResponseCallback = null;
    WSAppContextCallback wsAppContextCallback = null;
    WSRealmNameCallbackImpl wsRealmNameCallback = null;
    WSX509CertificateChainCallback wsX509CertificateCallback = null;
    WSAuthMechOidCallbackImpl wsAuthMechOidCallback = null;

    Callback[] callbacks = new Callback[9];
    callbacks[0] = nameCallback = new NameCallback("Username: ");
    callbacks[1] = passwordCallback = new PasswordCallback("Password: ", false);
    callbacks[2] = wsCredTokenCallback = new WSCredTokenCallbackImpl("Credential Token: ");
    callbacks[3] = wsServletRequestCallback = new WSServletRequestCallback("HttpServletRequest: ");
    callbacks[4] = wsServletResponseCallback = new WSServletResponseCallback("HttpServletResponse: ");
    callbacks[5] = wsAppContextCallback = new WSAppContextCallback("ApplicationContextCallback: ");
    callbacks[6] = wsRealmNameCallback = new WSRealmNameCallbackImpl("Realm name:");
    callbacks[7] = wsX509CertificateCallback = new WSX509CertificateChainCallback("X509Certificate[]: ");
    callbacks[8] = wsAuthMechOidCallback = new WSAuthMechOidCallbackImpl("AuthMechOid: ");

    try {
      _callbackHandler.handle(callbacks);
    } catch (Exception e) {
      // handle exception
    }

    if (nameCallback != null)
      username = nameCallback.getName();

    if (passwordCallback != null)
      passwordChar = passwordCallback.getPassword();

    if (wsCredTokenCallback != null)
      credToken = wsCredTokenCallback.getCredToken();

    if (wsServletRequestCallback != null)
      request = wsServletRequestCallback.getHttpServletRequest();

    if (wsServletResponseCallback != null)
      response = wsServletResponseCallback.getHttpServletResponse();

    if (wsAppContextCallback != null)
      appContext = wsAppContextCallback.getContext();

    if (wsRealmNameCallback != null)
      realm = wsRealmNameCallback.getRealmName();

    if (wsX509CertificateCallback != null)
      certChain = wsX509CertificateCallback.getX509CertificateChain();

    if (wsAuthMechOidCallback != null)
      authMechOid = wsAuthMechOidCallback.getAuthMechOid();

    _subject.getPrivateCredentials().add("username = " + username);
    _subject.getPrivateCredentials().add("password = " + String.valueOf(passwordChar));
    _subject.getPrivateCredentials().add("realm = " + realm);
    _subject.getPrivateCredentials().add("authMechOid = " + authMechOid.toString());

    return true;
  }

  public boolean commit() throws LoginException {
    return true;
  }

  public boolean abort() {
    return true;
  }

  public boolean logout() {
    return true;
  }

}