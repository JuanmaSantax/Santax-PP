import { useState } from "react";
import { addRepairedArea } from "../../api/repairedAreaService";

function WorkOrderDatail({ order, onUpdate }){
    const [areaName, setAreaName] = useState("");
    const [jobDetail, setJobDetail] = useState("");
    const [newAdjustment, setNewAdjustment] = useState({tinta: "", cantidad: ""});

    const handleAddArea = async () => {
        if (!areaName || !jobDetail) return alert("Completa ambos campos");
    
        const areaData = {
        areaName: areaName,
        jobDetail: jobDetail,
        workOrderId: order.id // Usamos el ID de la orden que recibimos por props
      };
        try {
          await addRepairedArea(areaData);
          setAreaName(""); // Limpiamos inputs
          setJobDetail("");
          if(onUpdate) onUpdate(); // <--- IMPORTANTE: Esto refresca la lista de vehículos y trae la nueva pieza
      } catch (error) {
        alert("Error al guardar la pieza");
      }
    };

    return (
        <div style={{ border: "2px solid #27ae60", padding: "20px", borderRadius: "8px", backgroundColor: "#f9f9f9", color: "#333" }}>
      <h2>Orden de Trabajo #{order.id}</h2>
      <p><strong>Descripción:</strong> {order.generalDescription}</p>
      <p><strong>Fecha Ingreso:</strong> {order.entryDate}</p>

      <hr />

      <div style={{ display: "flex", gap: "20px" }}>
        {/* SECCIÓN ÁREAS REPARADAS */}
       <div style={{ flex: 1 }}>
      <h3>🛠️ Áreas a Reparar</h3>
      <ul>
        {order.repairedAreas && order.repairedAreas.length > 0 ? (
                            order.repairedAreas.map((area) => (
          <li key={area.id}>
            <strong>{area.areaName}:</strong> {area.jobDetail}
          </li>
        )) 
        ): (
          <p style={{ color: "#888" }}>No hay piezas cargadas aún.</p>
        )}
      </ul>
      
        <input 
          type="text" 
          placeholder="Ej: Guardabarros" 
          value={areaName} // Asegúrate que este estado se llame igual que en tu handleAddArea
          onChange={(e) => setAreaName(e.target.value)} 
        />
        {/* Agrega el input para el detalle si quieres cargarlo desde aquí también */}
        <input 
          type="text" 
          placeholder="Detalle del trabajo" 
          value={jobDetail} 
          onChange={(e) => setJobDetail(e.target.value)} 
        />

        <button onClick={handleAddArea} style={{ backgroundColor: "#2ecc71" }}>
          + Añadir pieza
        </button>
      </div>

            {/* Seccion ajuste de color a mejorar*/}
        <div style={{ flex: 1 }}>
          <h3>🎨 Ajuste de Color</h3>
          <ul>
            {order.colorAdjustments?.map((adj) => (
              <li key={adj.id}>{adj.tintName}: {adj.amount}gr</li>
            ))}
          </ul>
          <input 
            placeholder="Tinta" 
            onChange={(e) => setNewAdjustment({...newAdjustment, tinta: e.target.value})} 
          />
          <input 
            placeholder="Gramos" 
            type="number" 
            onChange={(e) => setNewAdjustment({...newAdjustment, cantidad: e.target.value})} 
          />
          <button onClick={() => alert("Llamar API para guardar ajuste")}>Registrar Mezcla</button>
        </div>
      </div>
    </div>

    )
} 

export default WorkOrderDatail;