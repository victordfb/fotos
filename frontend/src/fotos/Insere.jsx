import React from 'react';
import './Insere.css';

export class Insere extends React.Component {

    render() {
        return (
            <div className="insere-container">
                <span>Inserir um novo</span>
                <br />
                <br />
                <form>
                    <label htmlFor="codigo">Código</label>
                    <input name="codigo" type="text" />
                    <label htmlFor="nome">Nome</label>
                    <input name="nome" type="text" />
                    <button>Inserir</button>
                </form>
            </div>
        )
    }
}