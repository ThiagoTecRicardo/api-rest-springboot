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
> Fazer login no console Web e seguir os procedimentos a seguir:

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
      > CPU -> Request = 2 cores | CPU -> Limit = 4 cores | Memory -> Request = 200 Mi | Memory -> Limit = 350 Mi
      - Clique no botão "Create";
      - Aguarde a cliação da aplicação;
      - Para acessar a documentação da aplicação adicione **/swagger-ui/** após a **URL** gerada pelo Openshft para acesso da aplicação;
      > exemplo: http://api-rest-springboot-git-test-drive-anvisa.apps.cluster-wczjk.wczjk.sandbox1416.opentlc.com/swagger-ui/
            
## 5-Adicionar Trigger no Pipeline:
1. Selecione no menu lateral **"Pipelines"**;
2. Selecione do lado direito do pipeline o botão, Conforme imagem;
3. Exemplo:
<img width="1438" alt="Screen Shot 2022-03-27 at 19 26 32" src="https://user-images.githubusercontent.com/85974419/160303742-2be97bb1-fd51-4cf9-8a33-0a13075a57f7.png">

4. Irá abrir uma lista de opções, selecione "Add Trigger";

<img width="1438" alt="Screen Shot 2022-03-27 at 19 30 11" src="https://user-images.githubusercontent.com/85974419/160303881-96878070-9a5e-425e-a7c8-b8cd207e6a15.png">

5. Na proxima tela abrirá um formulario, selecione na aopção "Git Provider type" selecione o valor = "github-push" e clique no botão "Add";

<img width="1438" alt="Screen Shot 2022-03-27 at 19 33 28" src="https://user-images.githubusercontent.com/85974419/160304070-4a29e3f2-fe28-44d9-813a-995facccb78d.png">

6. Selecione no menu lateral "Topology", no pod criado de sua Trigger clique no botão para ter acesso a URL, conforme imagem:
<img width="1438" alt="Screen Shot 2022-03-27 at 19 39 30" src="https://user-images.githubusercontent.com/85974419/160304231-b6139533-f04f-46f9-ba55-a3e7bac45d0a.png">

7. Copie a URL gerada que abrirá em outra aba do seu navegador após o clique;

<img width="1438" alt="Screen Shot 2022-03-27 at 19 43 51" src="https://user-images.githubusercontent.com/85974419/160304329-9ed20a35-9975-4256-9b73-ef896f9fada7.png">

8. Acesso seu repositório, clique nas seguintes opções: Settings -> Webhooks -> Add webhook:

<img width="1438" alt="Screen Shot 2022-03-27 at 19 50 10" src="https://user-images.githubusercontent.com/85974419/160304525-e1548a74-bbfb-422c-84cb-ceb8d14c3fa6.png">

9. No formulario que aparecerá cole a URL que copiou no passo 7 e cole no campo "Payload URL" , selecionar no compo "Content type" a opção "aplication/json" e depois clique no botão "Add webhook";

<img width="1438" alt="Screen Shot 2022-03-27 at 20 43 58" src="https://user-images.githubusercontent.com/85974419/160306378-fc15429f-6281-4c2e-88ee-a12b93a9a467.png">


## 6- Testar Trigger com o Webhook do GitHub:

#### Passos para teste:

1. Alterar o arquivo "index.html" na linha 46 colocando seu nome na tag **h3** que está no seguinte caminho "/src/main/resources/static/";
      
<img width="1433" alt="Screen Shot 2022-03-28 at 12 48 28" src="https://user-images.githubusercontent.com/85974419/160437149-23052688-927e-45c6-89ee-f4d49bdbdc87.png">

2. Após essa alteração clique no botão "commit changes";

<img width="1433" alt="Screen Shot 2022-03-28 at 12 51 23" src="https://user-images.githubusercontent.com/85974419/160437667-c55f3ac4-41c0-42d4-bc4d-41d90f9283fa.png">

3. No console do OCP, voce pode acompahar a Pipeline iniciando um novo build e deploy da nova versão da Aplicação;

<img width="1433" alt="Screen Shot 2022-03-28 at 12 54 54" src="https://user-images.githubusercontent.com/85974419/160438431-80a22fcc-81c6-44f8-9c9d-b837b3480bf8.png">

      
## 7- Escalar a aplicação manualmente (via Webconsole)

1. Acessar no menu lateral a opção "Topology", clique no icone do POD da aplicação e na sessão "Details" clique no botão para subir mais uma instancia da Aplicação:

<img width="1433" alt="Screen Shot 2022-03-28 at 13 40 40" src="https://user-images.githubusercontent.com/85974419/160447055-731acc1e-5db1-4b1c-9943-612914efb0bc.png">


## 8- Escalar a aplicação manualmente por linha de comando:

> oc scale deployment <name_deployment> --replicas=3 | oc get pods

## 9- Downscale manual por linha de comando:
> oc scale deployment <name_deployment> --replicas=0 | oc get pods

## 10- Downscale manual (via Webconsole)

1. Acessar no menu lateral a opção "Topology", clique no icone do POD da aplicação e na sessão "Details" clique no botão para baixar as instancias da Aplicação:

<img width="1433" alt="Screen Shot 2022-03-28 at 13 40 40" src="https://user-images.githubusercontent.com/85974419/160447055-731acc1e-5db1-4b1c-9943-612914efb0bc.png">


## 11- Autoscale da aplicação:

1. Acessar no menu lateral a opção "Topology", clique no icone do POD da aplicação e na sessão "Actions" clique na opcão "Add HorizontalPodAutoscaler":

<img width="1433" alt="Screen Shot 2022-03-28 at 14 05 37" src="https://user-images.githubusercontent.com/85974419/160450990-9b32debb-c508-4f97-ae16-e8407d55f76b.png">

2. Será aberto um formulario para preenchimento dos parametros, colocar os valores e clique no botão "Save" comforme imagem:

<img width="1433" alt="Screen Shot 2022-03-28 at 14 07 26" src="https://user-images.githubusercontent.com/85974419/160451001-f3d08378-cfdb-4796-ae37-28b511271396.png">


## 12 -Mostrar logs da aplicação (Web)

1. Acessar no menu lateral a opção "Topology", clique no icone do POD da aplicação e na sessão "Resources" clique no botão para baixar as instancias da Aplicação:

<img width="1433" alt="Screen Shot 2022-03-28 at 13 58 04" src="https://user-images.githubusercontent.com/85974419/160449754-b05ceaf4-a703-4c6b-8731-c433bad4f531.png">

2. Abrirá a tela de logs da aplicação:

<img width="1433" alt="Screen Shot 2022-03-28 at 13 59 49" src="https://user-images.githubusercontent.com/85974419/160449765-3848ba95-a4f4-4832-8bad-bcfa120d0f85.png">


## 13- Mostrar logs via linha de comando:

> oc logs <pod>

> Item opcional: *Disparar o teste AB (Pedir que os participantes executem caso tenham o pacote httpd-tools (AB))
