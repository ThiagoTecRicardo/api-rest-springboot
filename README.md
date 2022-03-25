# App - Test Drive
Projeto Java + Bootstrap 

# Passos a seram abordados:

## Explorando o ambiente (Mostrar o console, mostrar o catalogo, mostrar operators)
Instalar Operators: (pipeline, Web Terminal) (Somente 2 pessoas poderão executar, um instala o Operator de Pipeline e o outro instala o Web Terminal)
Explorando o CLI (oc project, oc projects, oc get nodes, oc get pods -n openshift-console)
Subir a aplicação no OCP como Pipeline padrão (importante subir já com a parametrização de recursos: CPU/Memory)
Adicionar Trigger no Pipeline
Testar Trigger com o Webhook do GitHub
Escalar a aplicação manualmente (via Webconsole)
Escalar a aplicação manualmente (via CLI # oc scale deployment <name_deployment> --replicas=3 ; oc get pods)
Downscale manual (CLI # oc scale deployment <name_deployment> --replicas=0 ; oc get pods)
Downscale manual (WebConsole)
Autoscale da aplicação (Configurar o HPA)
Mostrar logs da aplicação (Web)
Mostrar logs via CLI (oc logs <pod>)
Disparar o teste AB (Pedir que os participantes executem caso tenham o pacote httpd-tools (AB))
