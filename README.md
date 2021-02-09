## Overview

### In this project was implemented custom Spring Boot starter
### Also it was written test.

#### You can use this starter with next dependency:
```
       <dependency>
           <groupId>com.github.bbodnar.springbootstarner.signature</groupId>
           <artifactId>signature-starter</artifactId>
           <version>0.0.1-SNAPSHOT</version>
       </dependency>
```
#### And you can configure this starter with `property` file

```
demo.signature.username=
demo.signature.extra.retention-period=
demo.signature.enable=
```

It was used 
[this](https://www.youtube.com/watch?v=znpSvljp8ig&ab_channel=EPAMSaint-Petersburg)
tutorial

##### Workflow Spring Boot with starters is next:
1. `@SpringBootApplication`
2. `@EnableAutoConfiguration`
3. `@Import({EnableAutoConfigurationImportSelector.class})`
4. `List<String> configurations = SpringFactoriesLoader.loadFactoryNames()` - it takes files `spring.factories`, 
   where is pointed a lot of configurations, for example
```   
    org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
  com.github.bbodnar.signature.starter.autoconfigure.SignatureAutoConfiguration
```

5. Load them with condition (It's a lot of condition annotations):

```
@ComponentScan("com.github.bbodnar.signature.starter")
@ConditionalOnProperty(value = "demo.signature.enable", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(SignatureProperties.class)
public class SignatureAutoConfiguration {
}
```
   

## Release Notes
Can be found in [RELEASE_NOTES](RELEASE_NOTES.md).

## Authors
* Bohdan Bodnar - [b-bodnar](https://github.com/b-bodnar)

## Contributing
Please, follow [Contributing](CONTRIBUTING.md) page.

## Code of Conduct
Please, follow [Code of Conduct](CODE_OF_CONDUCT.md) page.

## License
This project is Apache License 2.0 - see the [LICENSE](LICENSE) file for details
