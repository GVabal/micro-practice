export const environment = {
  production: true
};

export const api = {
  uri: {
    postOffice: {
      getAllParcels: 'http://localhost:8002/parcels',
      receiveParcel: 'http://localhost:8002/parcels'
    },
    shop: {
      getAllOrders: 'http://localhost:8000/orders',
      takeOrder: 'http://localhost:8000/orders',
      initSomeOrders: 'http://localhost:8000/orders/init'
    },
    warehouse: {
      initSomeThings: 'http://localhost:8001/inventory/init',
      getAllThings: 'http://localhost:8001/inventory',
      doThing: 'http://localhost:8001/inventory/do'
    },
    factory: {
      getAllOrders: 'http://localhost:8003/',
      takeSingleThingOrder: 'http://localhost:8003/take-order'
    }
  }
};