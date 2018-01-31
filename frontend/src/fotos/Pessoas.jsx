import React from 'react';
import './Pessoas.css';
import { Insere } from './Insere';

export class Pessoas extends React.Component {

    constructor() {
        super();

        this.state = { pessoas: [] }
    }

    componentDidMount() {

        this.atualizarLista();
    }

    atualizarLista() {
        fetch("http://localhost:8080/pessoas")
        .then((res) => res.json())
        .then((json) => this.setState({ pessoas: json }));
    }

    getPessoas() {
        return this.state.pessoas.map(pessoa => {
            return (
                <li key={pessoa.codigo}>
                    <div>
                        {pessoa.nome}
                    </div>
                    <div>Ações</div>
                </li>
            )
        });
    }

    render() {
        return (
            <div className="container">
                <Insere onInsere={() => this.atualizarLista() } />
                <br />
                <span className="titulo">Listagem de pessoas</span>
                <ul className="listagem">
                    {this.getPessoas()}
                </ul>
            </div>
        );
    }
}