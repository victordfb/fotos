import React from 'react';
import {Link} from 'react-router-dom';

import './Imagens.css';

export class Imagens extends React.Component {

    upload(event){
        let data = new FormData();
        data.append("file", event.target.files[0]);
        data.append("codigo", this.props.match.params.codigo);

        fetch('http://localhost:8080/pessoas/avatar', {
            method: 'POST',
            body: data
        })
        .then(response => response.json())
        .then(success => console.log(success))
        .catch(error => console.log(error));
    }

    render() {
        return (
            <div className="imagem-container">
                <Link to="/" className="botao-voltar">Voltar</Link>
                <br />
                <br />
                <div className="foto-principal">
                    <span>Foto principal</span>
                    <div className="quadro">.</div>
                    <input name="file" onChange={(event) => this.upload(event)} type="file" />
                </div>
            </div>
        )
    }
}
