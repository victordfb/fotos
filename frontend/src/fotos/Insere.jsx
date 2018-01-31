import React from 'react';
import './Insere.css';

export class Insere extends React.Component {

    constructor() {
        super();

        this.state = { codigo: "", nome: "" }
    }

    updatePessoa(event) {

        let pessoa = this.state;
        pessoa[event.target.name] = event.target.value;
        this.setState(pessoa);
    }

    inserir() {

        const esc = encodeURIComponent;
        const query = Object.keys(this.state)
            .map(k => esc(k) + '=' + esc(this.state[k]))
            .join('&');

        fetch(`http://localhost:8080/pessoas?${query}`, { method: 'PUT' })
        .then(res => res.json())
        .then(json => this.props.onInsere(json));
    }

    handleSubmit(event) {
        event.preventDefault();
    }

    render() {
        return (
            <div className="insere-container">
                <span>Inserir um novo</span>
                <br />
                <br />
                <form onSubmit={(event) => this.handleSubmit(event)}>
                    <label htmlFor="codigo">Código</label>
                    <input name="codigo" type="text" onChange={(event) => this.updatePessoa(event)} value={this.state.codigo}/>
                    <label htmlFor="nome">Nome</label>
                    <input name="nome" type="text" onChange={(event) => this.updatePessoa(event)} value={this.state.nome}/>
                    <button onClick={() => this.inserir()}>Inserir</button>
                </form>
            </div>
        );
    }
}