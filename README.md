# MuniDigital CarWash API

API para gestionar un lavadero de autos

## Endpoints

### Cliente

#### POST /cliente/crear

Creacion de Cliente

```json
{
  "nombre": "Clara",
  "mail": "clara@gmail.com",
  "telefono": 1120204040
}
```

#### GET /cliente/getAll

Obtener todos los clientes

### Vehiculo

#### POST /vehiculo/crear

Creacion de Vehiculo

```json
{
  "modelo": "Ford Raptor",
  "matricula": "H555GGG",
  "tipoVehiculo":  {
    "tipoVehiculoId": 4,
    "nombre": "4X4"
  },
  "cliente":  {
    "clienteId": 3,
    "nombre": "Nico",
    "mail": "nico@gmail.com",
    "telefono": 1166945555
  }
}
```

#### GET /cliente/getAll

Obtener todos los vehiculos

### AtributoVehiculo

#### POST /atributo/crear

Creacion de Atributo de un Vehiculo

```json
{
  "vehiculo":  {
    "vehiculoId": 1,
    "modelo": "Renault Duster",
    "matricula": "A953XSD",
    "tipo":  {
      "tipoVehiculoId": 1,
      "nombre": "SUV"
    },
    "cliente":  {
      "clienteId": 3,
      "nombre": "Nico",
      "mail": "nico@gmail.com",
      "telefono": 1166945555
    }
  },
  "nombre": "Puertas",
  "valor": "5"
},
```

#### DELETE /atributo/borrar?vehiculoAtributoId={ID}

Borrar un atributo

#### GET /atributo/getAll

Obtener todos los atributos

### Turno

#### POST /turno/crear

Creacion de Turno

```json
{
  "fecha": "2026-02-23 15:30:00",
  "tipoServicio": "LavadoExterior",
  "estado": "Finalizado",
  "vehiculo":  {
    "vehiculoId": 1,
    "modelo": "Renault Duster",
    "matricula": "A953XSD",
    "tipo": {
      "tipoVehiculoId": 1,
      "nombre": "SUV"
    },
    "cliente": {
      "clienteId": 3,
      "nombre": "Nico",
      "mail": "nico@gmail.com",
      "telefono": 1166945555
    }
  }
}
```

#### GET /turno/getAll

Obtener todos los turnos

### Cobro

#### POST /cobro/crear

Creacion de Cobro

```json
{
  "monto": 1000,
  "turno": {
    "turnoId": 1,
    "fecha": "2026-02-23T15:30:00",
    "tipoServicio": "LavadoExterior",
    "estado": "Finalizado",
    "vehiculo": {
      "vehiculoId": 1,
      "modelo": "Renault Duster",
      "matricula": "A953XSD",
      "tipo": {
        "tipoVehiculoId": 1,
        "nombre": "SUV"
      },
      "cliente": {
        "clienteId": 3,
        "nombre": "Nico",
        "mail": "nico@gmail.com",
        "telefono": 1166945555
      }
    }
  }
}
```

#### GET /cobro/getAll

Obtener todos los cobros
