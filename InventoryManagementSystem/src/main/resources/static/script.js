const apiUrl = 'http://localhost:8081/inventory/items';

async function fetchInventory() {
  const response = await fetch(apiUrl);
  const items = await response.json();
  const list = document.getElementById("inventoryList");
  list.innerHTML = '';

  items.forEach(item => {
    const li = document.createElement("li");

    const span = document.createElement("span");
    span.textContent = `${item.name} - ${item.quantity}`;

    const delBtn = document.createElement("button");
    delBtn.className = "btn delete";
    delBtn.textContent = "🗑️ Delete";
    delBtn.onclick = () => deleteItem(item.id);

    li.appendChild(span);
    li.appendChild(delBtn);
    list.appendChild(li);
  });
}

async function addItem() {
  const name = document.getElementById("itemName").value.trim();
  const qty = parseInt(document.getElementById("itemQuantity").value);

  if (name && qty > 0) {
    const newItem = { name, quantity: qty };
    const res = await fetch(apiUrl, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(newItem)
    });

    if (res.ok) {
      document.getElementById("itemName").value = '';
      document.getElementById("itemQuantity").value = '';
      fetchInventory();
    } else {
      alert("Failed to add item");
    }
  } else {
    alert("Please enter valid data");
  }
}

async function deleteItem(id) {
  const res = await fetch(`${apiUrl}/id/${id}`, {
    method: 'DELETE'
  });

  if (res.ok) {
    fetchInventory();
  } else {
    alert("Failed to delete item");
  }
}

window.onload = fetchInventory;
