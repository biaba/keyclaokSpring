### Setting up Keycloak to access protected resource
### INFO:
Keycloak 17.0.0
MySQL connector 8.0.27
MySQL server 8.0
Java SE 1.8

Keycloak server runs as authorization server and connects to mysql.
Keycloak schema is separate from resource schema in db
Trying access any protected resource (Spring Security on resource server) will require authentication+authorization

Configured to run as standalone. If required to run in another mode, should be configured. (Currently in standalone.xml)
Important! KeyCloak is configured for our project to run on :8081 port

### ACTIONS BEFORE RUNNING:
1. MySQL server
   CREATE DATABASE keycloak;

2. starting keycloak server:
   cmd: move to keycloak_version/bin
   A. First time:
   standalone.sh(or .bat for windows) -Dkeycloak.migration.action=import -Dkeycloak.migration.provider=singleFile -Dkeycloak.migration.file=SpringSecurity-realm.json -Dkeycloak.migration.strategy=OVERWRITE_EXISTING
   B. Later on:
   standalone.sh(or .bat for windows)

### admin console for keycloak server:
3. http://localhost:8080/auth/
   create user to log in as admin
   (e.g. username: admin, password: admin)

### Wait a while before :
4. start using our REST API
   all resources /** are protected
   user: user1
   pssw: user1

to logout: localhost:9090/logout

### Running from Postman
- authorization tab
- Type: OAuth2
- Grant type: any
- Callback URL: http://localhost:8081/*
- Auth URL: http://localhost:8080/auth/realms/SpringSecurity/protocol/openid-connect/auth
- Access Token URL: http://localhost:8080/auth/realms/SpringSecurity/protocol/openid-connect/token
- clientId: login-app
- client secret: 5681ce83-c6ce-4949-9c2e-4daa3e7dfafe
  A. Get new access token
  B. POST/GET/etc
