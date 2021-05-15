helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm inspect values prometheus-community/prometheus > values.yml
helm upgrade --install prometheus prometheus-community/prometheus --values ./values.yml --namespace prometheus

helm repo add bitnami https://charts.bitnami.com/bitnami
helm install grafana --set admin.user=admin --set admin.password=admin bitnami/grafana