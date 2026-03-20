import { useEffect, useState } from 'react'
import VehicleForm from './VehicleForm'
import { deleteVehicle } from '../../api/vehicleService'
import WorkOrdersForm from '../workOrders/workOrdersForm'
import WorkOrderDetail from '../workOrders/workOrderDetail'

function VehicleList({ vehicles, onVehicleCreated, onEditVehicle }) {

  const [selectedVehicle, setSelectedVehicle] = useState(null)
  const [viewingOrder, setViewingOrder] = useState(null) // Nuevo estado para almacenar la orden que se quiere ver en detalle

  // Estado para saber qué formulario de "crear" está abierto
  const [addingOrderId, setAddingOrderId] = useState(null);
  // Estado para "ver" los detalles de una orden existente
  const [viewingOrderId, setViewingOrderId] = useState(null);

  const handleDelete = async (id) => {
    if (window.confirm("¿Estás seguro de eliminar este vehículo?")) {
      await deleteVehicle(id);
      onVehicleCreated(); // Refresca la lista
    }
  };

  return (
    <div className="container">
      <ul style={{ listStyle: 'none', padding: 0 }}>
        {vehicles.map((vehicle) => {
          // USAMOS UN SOLO NOMBRE: hasActiveOrder
          const hasActiveOrder = vehicle.workOrders && vehicle.workOrders.length > 0;

          return (
            <li key={vehicle.id} style={{ borderBottom: '1px solid #444', padding: '15px', color: 'white' }}>
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                <div>
                  <strong>{vehicle.patent}</strong> - {vehicle.make} {vehicle.model} ({vehicle.year})
                </div>

                <div className="actions">
                  <button onClick={() => onEditVehicle(vehicle)}>Edit</button>
                  <button onClick={() => handleDelete(vehicle.id)} style={{ backgroundColor: '#c0392b', color: 'white' }}>Delete</button>

                  {/* BOTÓN DINÁMICO UNIFICADO */}
                  {hasActiveOrder ? (
                    <button 
                      onClick={() => setViewingOrder(vehicle.workOrders[0])}
                      style={{ backgroundColor: '#27ae60', color: 'white' }}
                    >
                      Ver Orden ({vehicle.workOrders.length})
                    </button>
                  ) : (
                    <button 
                      onClick={() => setAddingOrderId(vehicle.id)}
                      style={{ backgroundColor: '#2980b9', color: 'white' }}
                    >
                      + Nueva Orden
                    </button>
                  )}
                </div>
              </div>

              {/* Formulario para CREAR */}
              {addingOrderId === vehicle.id && (
                <div style={{ marginTop: '10px', background: '#222', padding: '15px', borderRadius: '8px' }}>
                  <WorkOrdersForm
                    vehicleId={vehicle.id}
                    onWorkOrderCreated={() => {
                      setAddingOrderId(null);
                      onVehicleCreated(); 
                    }}
                  />
                  <button onClick={() => setAddingOrderId(null)} style={{marginTop: '10px'}}>Cancelar</button>
                </div>
              )}

              {/* DETALLE DE LA ORDEN (Recuadro verde de tu imagen) */}
              {viewingOrder && viewingOrder.vehicleId === vehicle.id && (
                <div style={{ marginTop: '10px', border: '1px dashed #27ae60', padding: '15px', borderRadius: '8px' }}>
                  <WorkOrderDetail 
                    order={viewingOrder} 
                    onUpdate={onVehicleCreated} 
                  />
                  <button 
                    onClick={() => setViewingOrder(null)} 
                    style={{ marginTop: '10px', backgroundColor: '#444', color: 'white' }}
                  >
                    Cerrar Detalle
                  </button>
                </div>
              )}
            </li>
          );
        })}
      </ul>
    </div>
  );

}

export default VehicleList



   {/* Espacio para VER la orden (Parte 3) 
              {viewingOrderId === (vehicle.workOrders?.[0]?.id) && (
                <div style={{ marginTop: '10px', border: '1px dashed #27ae60', padding: '10px' }}>
                  <p><strong>Detalle de Orden:</strong> {vehicle.workOrders[0].generalDescription}</p>
                  <p><strong>Ingreso:</strong> {vehicle.workOrders[0].entryDate}</p>
                  {/* Aquí irían tus tablas de RepairedArea y ColorAdjustment }
                  <button onClick={() => setViewingOrderId(null)}>Cerrar Detalle</button>
                </div>
              )}*/}
              