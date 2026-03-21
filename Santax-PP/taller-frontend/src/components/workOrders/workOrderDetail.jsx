import { useState } from "react";
import { addRepairedArea } from "../../api/repairedAreaService";
import { addColorAdjustment } from "../../api/colorAdjustmentService";



  const initialAdjustmentState = ({
      tintName: "",
       baseColorCode: "",
       paintSupplier: "",
       finalFormula: "",
       touchUpDescription: "",
       primerG1_G7: "",
       numberOfCoats: ""
      });

function WorkOrderDatail({ order, onUpdate }){
    const [areaName, setAreaName] = useState("");
    const [jobDetail, setJobDetail] = useState("");
    const [newAdjustment, setNewAdjustment] = useState(initialAdjustmentState);
    const [useDamero, setUseDamero] = useState(false); // Nuevo estado para el checkbox

  
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

     const handleAddAdjustment = async () => {
      if(!newAdjustment.tintName || !newAdjustment.paintSupplier) return alert("Completa los campos de tinta y proveedor");
      const colorData = {
        workOrderId: order.id,
        tintName: newAdjustment.tintName,
        baseColorCode: newAdjustment.baseColorCode,
        paintSupplier: newAdjustment.paintSupplier,
        finalFormula: newAdjustment.finalFormula,
        touchUpDescription: newAdjustment.touchUpDescription,
        primerG1_G7: useDamero ? newAdjustment.primerG1_G7 : "",
        numberOfCoats: useDamero ? newAdjustment.numberOfCoats : ""
      }
      try {
            // await addColorAdjustment(colorData);
            console.log("Guardando Color:", colorData);
            
            // Limpiamos todos los inputs devolviendo el estado a su valor inicial
            setNewAdjustment(initialAdjustmentState);
            setUseDamero(false); // Reseteamos el checkbox también
            
            if(onUpdate) onUpdate(); // Refresca la lista
        } catch (error) {
            alert("Error al guardar el ajuste de color");
        }

    }

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

       {/* SECCIÓN AJUSTE DE COLOR */}
          <div style={{ flex: 1, backgroundColor: "#fff", padding: "15px", borderRadius: "5px", border: "1px solid #ddd" }}>
            <h3>🎨 Ajuste de Color</h3>
            <ul style={{ minHeight: "60px", paddingLeft: "20px", fontSize: "0.9em" }}>
              {order.colorAdjustments && order.colorAdjustments.length > 0 ? (
                order.colorAdjustments.map((adj) => (
                  <li key={adj.id}>
                    <strong>{adj.tintName}</strong> ({adj.baseColorCode}) - {adj.paintSupplier} <br/>
                    <small>Manos: {adj.numberOfCoats} | Primer: {adj.primerG1_G7}</small>
                  </li>
                )) 
              ): (
                <p style={{ color: "#888", fontSize: "0.9em" }}>No hay ajustes de color cargados.</p>
              )}
            </ul>
            
            <div style={{ display: "flex", flexDirection: "column", gap: "8px" }}>
                <input 
                  placeholder="Nombre de la tinta" 
                  value={newAdjustment.tintName} // <-- AHORA TIENE VALUE
                  onChange={(e) => setNewAdjustment({...newAdjustment, tintName: e.target.value})} 
                />
                <input 
                  placeholder="Codigo de color base" 
                  value={newAdjustment.baseColorCode}
                  onChange={(e) => setNewAdjustment({...newAdjustment, baseColorCode: e.target.value})} 
                />
                <input 
                  placeholder="Proveedor de pintura" 
                  value={newAdjustment.paintSupplier}
                  onChange={(e) => setNewAdjustment({...newAdjustment, paintSupplier: e.target.value})} 
                />
                <input 
                  placeholder="Fórmula final" 
                  value={newAdjustment.finalFormula}
                  onChange={(e) => setNewAdjustment({...newAdjustment, finalFormula: e.target.value})} 
                />
                <input 
                  placeholder="Descripción de retoque" 
                  value={newAdjustment.touchUpDescription}
                  onChange={(e) => setNewAdjustment({...newAdjustment, touchUpDescription: e.target.value})} 
                />
                {/* CHECKBOX DE DAMERO */}
                <label style={{ display: "flex", alignItems: "center", gap: "8px", marginTop: "10px", fontSize: "0.9em", cursor: "pointer" }}>
                  <input 
                    type="checkbox" 
                    checked={useDamero}
                    onChange={(e) => setUseDamero(e.target.checked)} 
                  />
                  ¿Se usó damero?
                </label>
                {useDamero && (
                  <div style={{ display: "flex", flexDirection: "column", gap: "8px", marginTop: "5px", padding: "10px", backgroundColor: "#f1f1f1", borderRadius: "5px" }}>
                    
                    <select 
                      value={newAdjustment.primerG1_G7}
                      onChange={(e) => setNewAdjustment({...newAdjustment, primerG1_G7: e.target.value})}
                      style={{ padding: "4px" }}
                    >
                      <option value="">Seleccionar Primer...</option>
                      <option value="G1">G1</option>
                      <option value="G2">G2</option>
                      <option value="G3">G3</option>
                      <option value="G4">G4</option>
                      <option value="G5">G5</option>
                      <option value="G6">G6</option>
                      <option value="G7">G7</option>
                    </select>

                    <input 
                      placeholder="Cantidad de manos" 
                      type="number"
                      min="0"
                      value={newAdjustment.numberOfCoats}
                      onChange={(e) => setNewAdjustment({...newAdjustment, numberOfCoats: e.target.value})} 
                    />
                  </div>
                )}

               <button onClick={handleAddAdjustment} style={{ backgroundColor: "#3498db", color: "white", padding: "8px", border: "none", borderRadius: "4px", cursor: "pointer", marginTop: "10px" }}>
                  + Registrar Ajuste
                </button>
            </div>
          </div>
    </div>
    </div>
    );
} 

export default WorkOrderDatail;