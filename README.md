### Aplicação spring no contexto kubernetes

- Aplicação simples, demonstrando um crud de produtos, adotando arquitetura clean, no entando é uma boa base.
- Atualmente as empresas veem adotando orquestradores de container, acaba deixando de fazer sentido o uso de algumas stacks do spring cloud, como: spring cloud config, spring cloud config bus, eureka, ribbon e gateway.
- Previamente devemos ter o minikube instalado, recomendo uso do linux.
- O arquivo script.bash, possui os passos para subir a aplicação.
- Versão mais recente do spring, ja da suporte para geração de imagens docker:
```
Spring Boot 2.3 oferece suporte para camadas, extraindo partes do JAR de gordura em camadas separadas. O recurso de camadas é desativado por padrão e precisa ser explicitamente ativado com o plugin Spring Boot Maven:
mvn spring-boot:build-image
```

##### Skaffold
É uma ferramenta simples com base na linha de comando, capaz de lidar com o fluxo de construção da sua aplicação, em um ambiente kubernetes. Os manifestos do kubernetes, devem ficar na pasta k8s.

```
skaffold init
skaffold dev --port-forward --trigger=manual --no-prune
```

O comando acima implanta sua apliação dentro do kubernetes, no contexto selecionado.

##### Jib
Nos auxilia na construção da imagem de aplicações java.


##### Observabilidade
Compreende os pontos abaixo:
- monitoramento
- logs
- rastreamento
- alerta
