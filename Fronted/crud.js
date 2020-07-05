function cadastrar(tema) {
    // recupera os dados
    let obj = new Object()
    // Caminho do endpoint
    let endpoint = '';
    //verifica qual o tema
    switch (tema) {
        case 'Pokemon':
            endpoint =  'pokemon';            
            break;
        case 'Spaceship':
            endpoint =  'spaceship';                     
            break;
        case 'Medicamento':
            endpoint =  'medicamento';                     
            break;                           
        default:
            break;
    }

    obj.attr1 = document.getElementById('attr1').value
    obj.attr2 = Number(document.getElementById('attr2').value)
    obj.attr3 = document.getElementById('attr3').value
    
    // vamos recuperar o ID por causa da atualização
    obj.id = document.getElementById('id').value

    // vamos consumir a API
    // cria um objeto para fazer requisição
    var request = new XMLHttpRequest()
        // abri a conexão
    request.open('POST', `http://localhost:8080/${endpoint}`, true);
    request.onload = function() {
            if ((request.status >= 200) && (request.status < 400)) {
                console.log(`Conectou com sucesso`)
            } else {
                console.log(`Problema na conexão`)
            }
        }
        // configura o cabeçalho de conexão
    request.setRequestHeader("Content-Type", "application/json")
        // envia os dados
    request.send(JSON.stringify(obj))
    alert(`${tema} cadastrado com sucesso!`);
}

function consultar(tema) {
    // Caminho do endpoint
    let endpoint = '';
    //verifica qual o tema
    switch (tema) {
        case 'Pokemon':
            endpoint =  'pokemon';            
            break;
        case 'Spaceship':
            endpoint =  'spaceship';            
            break;
        case 'Medicamento':
            endpoint =  'medicamento';           
        default:
            break;
    } 

    // recupera a tabela
    const tabela = document.getElementById("tabela")
    // consome a API
    var request = new XMLHttpRequest()
    request.open('GET', `http://localhost:8080/${endpoint}`, true)
    request.onload = function() {
        let obj = JSON.parse(this.response);
        if ((request.status >= 200) && (request.status < 400)) {
            console.log(`Conectou com sucesso`)
                // estrutura de repetição
            obj.forEach(obj => {
                // cria uma linha
                const linha = document.createElement('tr')
                    // adiciona a linha na tabela
                tabela.appendChild(linha)
                    // cria coluna 1
                const coluna1 = document.createElement('td')
                    // define conteúdo
                coluna1.textContent = obj.attr1
                    // cria coluna 2
                const coluna2 = document.createElement('td')
                    // define conteúdo
                coluna2.textContent = obj.attr2
                    // cria coluna 3
                const coluna3 = document.createElement('td')
                    // define conteúdo
                coluna3.textContent = obj.attr3
                    // cria coluna 4
                const coluna4 = document.createElement('td')
                    // conteúdo
                const imagemRemocao = document.createElement('img')
                imagemRemocao.setAttribute('src', 'remove.png')
                    // inserir o atributo onclick=remover(id)
                imagemRemocao.setAttribute('onclick', `remover(${obj.id}, ${tema}, ${endpoint})`)
                coluna4.appendChild(imagemRemocao)
                    // cria coluna 5
                const coluna5 = document.createElement('td')
                    // conteúdo
                const imagemAtualiza = document.createElement('img')
                imagemAtualiza.setAttribute('src', 'atualiza.png')
                    // inserir o atributo onclick=atualizar(obj)
                imagemAtualiza.setAttribute('onclick', `atualizar(${JSON.stringify(obj)})`)
                coluna5.appendChild(imagemAtualiza)
                    // adiciona as colunas na linha
                linha.appendChild(coluna1)
                linha.appendChild(coluna2)
                linha.appendChild(coluna3)
                linha.appendChild(coluna4)
                linha.appendChild(coluna5)
            })

        } else {
            console.log(`Problema na conexão`)
        }
    }

    request.send()

}

function remover(id, tema, endpoint) {
    // cria um objeto para fazer requisição
    let request = new XMLHttpRequest()
        // abri a conexão
    request.open('DELETE', `http://localhost:8080/${endpoint}/${id}`, true)
    request.onload = function() {
            if ((request.status >= 200) && (request.status < 400)) {
                console.log(`Conectou com sucesso`)
            } else {
                console.log(`Problema na conexão`)
            }
        }
        // envia os dados
    request.send()
    alert(`${tema} removido com suceso`);
        // executa on load do body, que chama o consultar
    location.reload()
}

function atualizar(obj) {
    // obter o dados do objeto obj que será atualizado e enviar para caixas de texto
    document.getElementById('attr1').value = obj.attr1
    document.getElementById('attr2').value = obj.attr2
    document.getElementById('attr3').value = obj.attr3
    document.getElementById('id').value = obj.id
}