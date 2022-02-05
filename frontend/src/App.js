import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, {useEffect, useState} from "react";
import Dropdown from "react-bootstrap/Dropdown";
import Button from "react-bootstrap/Button";

function App() {

    const [countries, setCountries] = useState([]);
    const [users, setUsers] = useState([]);
    const [selectedCountry, setSelectedCountry] = useState('Select Country');

    function getCountries() {
        fetch("http://localhost:8081/api/countries")
            .then(res => res.json())
            .then(
                (result) => {
                    setCountries(result.sort());
                },
                (error) => {
                    console.log(error);
                }
            )
    }

    function getUserData() {
        fetch("http://localhost:8081/api/users/" + selectedCountry)
            .then(res => res.json())
            .then(
                (result) => {
                    setUsers(result);
                    console.log(users)
                    Object.entries(users).map(user => user.name);
                },
                (error) => {
                    console.log(error);
                }
            )
    }

    function changeCountry(text) {
        setSelectedCountry(text)
    }

    useEffect(() => {
        getCountries();
        if (selectedCountry) {
            getUserData();
        }
        console.log(users)
    }, [selectedCountry])

    return (
        <div className="App">
            <div className="center-div">
                <Dropdown>
                    <Dropdown.Toggle variant="success" id="dropdown-basic">
                        {selectedCountry}
                    </Dropdown.Toggle>
                    <Dropdown.Menu>
                        {countries.map((country, i) => (
                            <Dropdown.Item key={i} onClick={() => changeCountry(country)}>{country}</Dropdown.Item>
                        ))}
                    </Dropdown.Menu>
                </Dropdown>
                <Button className="m-lg-5" onClick={getCountries}>Reload Data</Button>
            </div>

            {users.length > 0 &&
            <div className="container">
                <table className="table table-striped table-hover table-bordered">
                    <thead className="thead-dark">
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Gender</th>
                        <th scope="col">E-Mail</th>
                    </tr>
                    </thead>
                    <tbody>
                    {(users).map((user, i) => (
                        <tr key={i}>
                            <td key={user.id}>{user.name.first}, {user.name.last}</td>
                            <td key={user.id}>{user.gender}</td>
                            <td key={user.id}>{user.email}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
            }

        </div>
    );
}

export default App;
