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

##### Micrometer
Para monitorar uma aplicação spring boot, este é um exportador de métricas muito utilizado. Ele expõe dados num formato onde, por exemplo, prometheus consegui coletar.

#### Knative
- Knative introduz um nova forma de gerir as suas aplicações em kubernetes, adicionando novas características chave. Uma das mais significativas é a escala a zero ou seja, caso knative detecta um serviço que não esteja sendo utilizado, reduz o número de instâncias em execução para zero.
- Consequentemente, fornece uma funcionalidade de autoescalonamento integrada com base em concorrência ou número de pedidos por segundo.
- Todas essas caracteŕisticas são fornecedidas pelo componente chamado knative serving.

##### Funcionamento knative
- Podemos escolher entre dois tipos de autoscaling: concorrência ou pedidos por segundo (rps).
- autoscaling.knative.dev/target.
- exemplo para testar muitas requisições:

```
siege http://10.238.177.98:31298/products -i -v -r 1000 -c 150 --no-parser
```

### Consul
- na branch consul, utilizamos o mesmo para o papel de service discovery
- para colocar propriedades ou configurações, segue o padrão: config/nome do app/valor, profile

### Jenkins acesso ao docker:
- sudo usermod -aG docker jenkins

### Istio
- Instalar no path do seu so.
```
istioctl install
kubectl label namespace [seu namespace] istio-injection=enabled
```
- obs: caso os pods já estejam criados, delete e recrie-os.
