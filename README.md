# App - Test Drive
Projeto Java + Bootstrap 

# Passos a seram abordados:

## 1-Explorando o ambiente (Mostrar o console, mostrar o catalogo, mostrar operators)

## 2- Instalar Operators: 
(pipeline, Web Terminal) (Somente 2 pessoas poderão executar, um instala o Operator de Pipeline e o outro instala o Web Terminal)

#### Pré-requisitos:

> Acesso a um cluster do OpenShift Container Platform usando uma conta com permissões de administrador de cluster.

1. Procedimento de instalação Operator Web Terminal

      > Na perspectiva Administrador do console da web, navegue até Operadores → OperatorHub.

      - Use a caixa Filtrar por palavra-chave para pesquisar o Web Terminal Operator no catálogo e clique no bloco Web Terminal.

      - Leia a breve descrição sobre o Operador na página do Web Terminal e clique em Instalar.

      - Na página Instalar Operador, mantenha os valores padrão para todos os campos.

      - A opção rápida no menu Update Channel permite a instalação da versão mais recente do Web Terminal Operator.

      - A opção Todos os namespaces no cluster no menu Installation Mode permite que o Operador observe e esteja disponível para todos os namespaces no           cluster.

      - A opção openshift-operators no menu Installed Namespace instala o Operator no namespace padrão openshift-operators.

      - A opção Automática no menu Estratégia de Aprovação garante que as atualizações futuras do Operador sejam tratadas automaticamente pelo Gerenciador
      
      - Ciclo de Vida do Operador.

      - Clique em Instalar.

      - Na página Operadores Instalados, clique em Exibir Operador para verificar se o Operador está listado na página Operadores Instalados.


2. Procedimento de instalação Operator de Pipeline

      > Na perspectiva Administrador do console da web, navegue até Operadores → OperatorHub.

      - Use a caixa Filtrar por palavra-chave para pesquisar o Red Hat OpenShift Pipelines Operator no catálogo. 

      - Clique no bloco Operador do Red Hat OpenShift Pipelines.

      - Leia a breve descrição sobre o Operador na página do Operador do Red Hat OpenShift Pipelines. 

      - Clique em Instalar.
      
      - Na página Instalar Operador:

      - Selecione Todos os namespaces no cluster (padrão) para o Modo de instalação. 

      - Esse modo instala o Operador no namespace padrão openshift-operators, que permite que o Operador observe e seja disponibilizado para todos os              namespaces no cluster.

      - Selecione Automático para a Estratégia de Aprovação.

      - Isso garante que as futuras atualizações do Operator sejam tratadas automaticamente pelo Operator Lifecycle Manager (OLM).

      - Se você selecionar a estratégia de aprovação manual, o OLM cria uma solicitação de atualização.

      - Como administrador de cluster, você deve aprovar manualmente a solicitação de atualização do OLM para atualizar o Operador para a nova versão.

      - Selecione um canal de atualização.

      - O canal estável permite a instalação da última versão estável e suportada do Red Hat OpenShift Pipelines Operator.

      - O canal de visualização permite a instalação da versão de visualização mais recente do Red Hat OpenShift Pipelines Operator, que pode conter              recursos que ainda não estão disponíveis no canal estável e não são suportados.

      - Clique em Instalar. 

      - Você verá o Operador listado na página Operadores Instalados.
       

## 3- Explorando o CLI:

 #### Comandos:
 
 > oc projec |
 > oc projects |
 > oc get nodes |
 > oc get pods -n openshift-console


## 4- Subir a aplicação no OCP como Pipeline padrão:
(importante subir já com a parametrização de recursos: CPU/Memory)
> Fazer login no console Web e seguir os procedimentos a seguer:

1. Na pagina inicial selecione o menu +APP;
2. Clicar no link "create a Project";
3. Na janela que será aberta, preencha os campos:
> Name: colocar um nome para o projeto | Display Name: Colocar o nome que irá aparecer na lista de projetos | Description: Descrever o objetivo do projeto;
4. Na proxima tela selecionar a opção -> From Git
5. Será aberto uma tela de preenchimento para cadastro de sua aplicação:
      - No campo **Git Repo URL:** colocar a url do projeto do GitHub;
      - No campo **Git Reference:** colocar o valor = main
      - Marcar o checkbox na sessão **Pipelines**;
      - Cilcar no link **Resource limit** na sessão "**advanced options**";
      - No formulario que será aberto, colocar os seguiontes valores:
            > CPU -> Request = 20 | CPU -> Limit = 50 | Memory -> Request = 100 | Memory -> Limit = 200;
      - Clique no botão "Create";
      - Aguarde a cliação da aplicação;
            
## 5-Adicionar Trigger no Pipeline:
Descrevar esse passo

## 6- Testar Trigger com o Webhook do GitHub:
Descrevar esse passo

## 7- Escalar a aplicação manualmente (via Webconsole)

## 8- Escalar a aplicação manualmente:
(via CLI # oc scale deployment <name_deployment> --replicas=3 ; oc get pods)

## 9- Downscale manual:
(CLI # oc scale deployment <name_deployment> --replicas=0 ; oc get pods)

## 10- Downscale manual:
(WebConsole)

## 11- Autoscale da aplicação:
(Configurar o HPA)

## 12 -Mostrar logs da aplicação (Web)

## 13- Mostrar logs via CLI:
(oc logs <pod>)

> Disparar o teste AB (Pedir que os participantes executem caso tenham o pacote httpd-tools (AB))
