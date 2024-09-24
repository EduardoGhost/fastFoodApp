# FastFoodApp

O **FastFoodApp** é um aplicativo mobile de compras de comidas, desenvolvido para facilitar a navegação por categorias de alimentos, a seleção de pratos e a finalização de compras de maneira simples e intuitiva. A aplicação utiliza uma API gratuita para fornecer uma lista de categorias de alimentos e os itens correspondentes a cada categoria.

## Funcionalidades

- **Listar Categorias de Alimentos**: O aplicativo exibe uma lista de categorias, permitindo que o usuário navegue facilmente pelos tipos de comida disponíveis.
- **Listar Itens por Categoria**: Ao selecionar uma categoria, o usuário pode visualizar todos as comidas disponíveis dentro dessa categoria.
- **Adicionar ao Carrinho**: Os usuários podem adicionar itens ao carrinho diretamente da lista de comidas, preparando-os para a compra.
- **Concluir Compra**: O usuário pode finalizar sua compra, gerando um histórico das compras realizadas.
- **Histórico de Compras**: O aplicativo armazena o histórico das compras concluídas em um banco de dados local, permitindo que o usuário visualize pedidos anteriores.

O **FastFoodApp** foi projetado para proporcionar uma experiência de compra rápida e eficiente, com foco em simplicidade e praticidade.

## Tecnologias

- **Linguagem**: [Kotlin]
- **APIs**: [https://free-food-menus-api.onrender.com]
- **Banco de Dados**: [Room]
- **Interfaces**: [Jetpack Compose]
- **Consumo de API**: [Retrofit]

## Como Usar

1. Clone o repositório:
   ```bash
   git clone https://github.com/EduardoGhost/fastFoodApp

2. Navegue até o diretório do projeto:
   ```bash
   cd fastFoodApp
3. Conecte seu dispositivo ou inicie um emulador Android.
Execute o projeto:
   ```bash
   ./gradlew assembleDebug
Se estiver utilizando o Android Studio, basta abrir o projeto e clicar em Run para compilar e rodar no dispositivo.

Segue abaixo imagens das telas do aplicativo em execução:

<img src="https://github.com/EduardoGhost/fastFoodApp/blob/dev/assets/home.png" width="250">&emsp;
<img src="https://github.com/EduardoGhost/fastFoodApp/blob/dev/assets/listing.png" width="250">&emsp;
<img src="https://github.com/EduardoGhost/fastFoodApp/blob/dev/assets/cart.png" width="250">&emsp;
<img src="https://github.com/EduardoGhost/fastFoodApp/blob/dev/assets/history.png" width="250">&emsp;
