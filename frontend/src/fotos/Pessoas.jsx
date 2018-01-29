import React from 'react';

export class Pessoas extends React.Component {

    constructor() {
        super();

        this.state = { pessoas: [] }
    }

    componentDidMount() {
        fetch("http://localhost:8080/pessoas")
        .then((res) => res.json())
        .then((json) => this.setState({pessoas: json}))
    }

    getPessoas() {
        return this.state.pessoas.map(pessoa => {
            return <li key={pessoa.codigo}>{pessoa.nome}</li>
        });
    }

    render() {
        return (
            <div>
                <span>Listagem de pessoas</span>
                <ul>
                    {this.getPessoas()}
                </ul>
            </div>
        )
    }
}