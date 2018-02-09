import React from 'react';
import {Link} from 'react-router-dom';

import './Pessoas.css';
import {Insere} from './Insere';
import camera from '../photo-camera.svg';

export class Pessoas extends React.Component {

    constructor() {
        super();

        this.state = {pessoas: []}
    }

    componentDidMount() {

        this.atualizarLista();
    }

    atualizarLista() {
        fetch("http://localhost:8080/pessoas")
            .then((res) => res.json())
            .then((json) => this.setState({pessoas: json}));
    }

    newLink() {
        return (
            <Link to="/imagens">
                <img src={camera} className="icone-imagem" alt="Gerenciar imagens"/>
            </Link>
        )
    }

    getPessoas() {
        return this.state.pessoas.map(pessoa => {
            return (
                <li key={pessoa.codigo}>
                    <div>
                        {pessoa.nome}
                    </div>
                    <div>{this.newLink()}</div>
                </li>
            )
        });
    }

    /****************************************************************
     * Teste de upload
     * // Select your input type file and store it in a variable
const input = document.getElementById('fileinput');

// This will upload the file after having read it
const upload = (e) => {
  fetch('www.example.net', { // Your POST endpoint
    method: 'POST',
    headers: {
      "Content-Type": "You will perhaps need to define a content-type here"
    },
    body: e.currentTarget.result // This is the content of your file
  }).then(
    response => response.json() // if the response is a JSON object
  ).then(
    success => console.log(success); // Handle the success response object
  ).catch(
    error => console.log(error); // Handle the error response object
  );
};

// Event handler executed when a file is selected
const onSelectFile = (files) => {
  // Files is a list because you can select several files
  // We just upload the first selected file
  const file = input.files[0];
  const reader = new FileReader();

  // We read the file and call the upload function with the result
  reader.onload = upload;
  reader.readAsText(file);
};

// Add a listener on your input
// It will be triggered when a file will be selected
input.addEventListener('change', onSelectFile , false);
     */

    render() {
        return (
            <div className="container">
                <Insere onInsere={() => this.atualizarLista()}/>
                <br/>
                <span className="titulo">Listagem de pessoas</span>
                <ul className="listagem">
                    {this.getPessoas()}
                </ul>
            </div>
        );
    }
}