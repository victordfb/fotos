import React from 'react';
import {Link} from 'react-router-dom';

import './Imagens.css';

export class Imagens extends React.Component {

    constructor() {
        super();
        this.state = {image: null}
    }

    componentDidMount() {
        this.loadImage();
    }

    loadImage() {
        let codigo = this.props.match.params.codigo;
        fetch(`http://localhost:8080/pessoas/${codigo}/avatar`)
        .then(response => response.text())
        .then(imgBase64 => this.setState({image: imgBase64}))
    }

    upload(event) {

        let data = new FormData();
        data.append("file", event.target.files[0]);
        data.append("codigo", this.props.match.params.codigo);

        fetch("http://localhost:8080/pessoas/avatar", {
            method: 'POST',
            body: data
        })
        .then(response => response.json())
        .then(success => {
                if (success) {
                    this.loadImage();
                    return;
                }
                console.log("Erro ao ler retorno de sucesso do upload.");
            })
        .catch(error => console.log(error));
    }

    render() {
        return (
            <div className="imagem-container">
                <Link to="/" className="botao-voltar">Voltar</Link>
                <br/>
                <br/>
                <div className="foto-principal">
                    <span>Foto principal</span>
                    <div className="quadro">
                        <img src={"data:image/jpeg;base64," + this.state.image} alt="Imagem principal"/>
                    </div>
                    <input name="file" onChange={(event) => this.upload(event)} type="file"/>
                </div>
            </div>
        )
    }
}
