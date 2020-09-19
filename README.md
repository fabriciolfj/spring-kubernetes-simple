### Aplicação spring no contexto kubernetes

- Aplicação simples, demonstrando um crud de produtos, adotando arquitetura clean, no entando é uma boa base.
- Atualmente as empresas veem adotando orquestradores de container, acaba deixando de fazer sentido o uso de algumas stacks do spring cloud, como: spring cloud config, spring cloud config bus, eureka, ribbon e gateway.
- Previamente devemos ter o minikube instalado, recomendo uso do linux.
- O arquivo script.bash, possui os passos para subir a aplicação.
- Versão mais recente do spring, ja da suporte para geração de imagens docker:
```
mvn spring-boot:build-image
```
