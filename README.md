# OneToOneOneToManyandManyToMany
in this repository cover one to one, one to many, many to one, one to many ,many to many spring boot database mapping.
- learn about thymeleaf and configaretion.
- leran one to one database mapping.
- learn one to many database mapping.
- learn many to many database mapping.
- including all quick test with  @PostConstruct annotation 
- work with  @JsonIgnore
- add many to one database mapping.<br/>
- provide<b> Genaric way Rest API</b> Using DTO and Model Mapper on Product Entity.
- provide <b>Genaric way Rest API</b> Using DTO and Model Mapper<br/>
##learn about<br/>
- @MappedSuperclass.
- @PrePersist.
- @PreUpdate
- @Builder
- @JsonInclude(JsonInclude.Include.ALWAYS).
- @JsonInclude(JsonInclude.Include.NON_NULL).
- setRootUrl using application.properties.
- Model mapper
- implement <b> JWT </b> token....<br/>
```Java
 ES512 which uses Elliptic Curve algorithm. Since you are using a secret key, you want to use an HMAC algorithm which has the prefix "HS". So HS256, HS384, or HS512.
        *if you use a secrect key 🗝 use "HS512" like....
                Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS512, secret).compact();
        *If you don't have any secrect key then use the below algorithm 
                Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.ES512, secret).compact();
```
- DTO concept.<br/>

###Add generic way <b>SPRING SECURITY </b>with disable csrf and cors problem.<br/>
    - Add custom generic way spring security.<br/>
    - protection against cors problem<br/>
    - and add protection csrf problems<br/>
          <b>About CSRF </b><br/>
          CSRF stands for <b>Cross-Site Request Forgery(জালিয়াতি)<b/>. It is an attack that forces an end user to execute unwanted actions on a web application in which they are currently authenticated. CSRF attacks specifically target state-changing requests, not theft of data, since the attacker has no way to see the response to the forged request.<br/>
-Add  protection cors protection<br/>
    <b>About CORS </b><br/>
          <b>Cross-Origin Resource Sharing</b> (CORS) is a security concept that allows restricting the resources implemented in web browsers. It prevents the JavaScript code producing or consuming the requests against different origin

For example, your web application is running on 8080 port and by using JavaScript you are trying to consuming RESTful web services from 9090 port. Under such situations, you will face the Cross-Origin Resource Sharing security issue on your web browsers.

Two requirements are needed to handle this issue −

RESTful web services should support the Cross-Origin Resource Sharing.

RESTful web service application should allow accessing the API(s) from the 8080 port.<br/>
more update comming soon.....
