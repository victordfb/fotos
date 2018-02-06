import React from 'react';
import {Link} from 'react-router-dom';

import './Imagens.css';

export class Imagens extends React.Component {

    render() {
        return (
            <div className="imagem-container">
                <Link to="/" className="botao-voltar">Voltar</Link>
                <br />
                <br />
                <div className="foto-principal">
                    <span>Foto principal</span>
                    <div className="quadro"></div>

                </div>
            </div>
        )
    }
}
