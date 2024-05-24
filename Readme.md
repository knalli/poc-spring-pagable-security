# poc-spring-pagable-security

Run this Main and open `http://localhost:8080/` shows
```
Hello null!
```

which means no session. Follow the login and proceed with `user:password`.

Again visiting the root and confirm the output
```
Hello MyUserDetailsImpl[…]!
```

Changing in `Main` enabling `@EnableSpringDataWebSupport`. 
This will change the order of method argument resolvers and break existing `AuthenticationPrincipalArgumentResolver`.

Restart the app, repeat the steps and you will see
```
Hello {}!
```

indicating there is no `null` anymore, but something "empty" -- the proxy result.