const btn = document.getElementById("profileBtn");
const menu = document.getElementById("dropdownMenu");

btn.addEventListener("click", () => {
    menu.classList.toggle("active");
});

/* click ngoài -> đóng */
document.addEventListener("click", (e) => {
    if (!btn.contains(e.target) && !menu.contains(e.target)) {
        menu.classList.remove("active");
    }
});

// Badminton Court Sidebar Toggle
document.addEventListener('DOMContentLoaded', () => {
    const toggleBtn = document.getElementById('toggle-sidebar');
    const sidebar = document.getElementById('sidebar-san');
    const overlay = document.createElement('div');

    if (toggleBtn && sidebar) {
        overlay.className = 'fixed inset-0 bg-black/50 z-40 lg:hidden';
        overlay.style.display = 'none';
        document.body.appendChild(overlay);

        toggleBtn.addEventListener('click', () => {
            sidebar.classList.toggle('-translate-x-full');
            overlay.style.display = sidebar.classList.contains('-translate-x-full') ? 'none' : 'block';
        });

        overlay.addEventListener('click', () => {
            sidebar.classList.add('-translate-x-full');
            overlay.style.display = 'none';
        });
    }
});

// Booking Page Logic
if (document.getElementById('datePicker')) {
  // Flatpickr date picker
  flatpickr('#datePicker', {
    dateFormat: 'd/m/Y',
    defaultDate: new Date(),
    minDate: 'today',
    locale: { firstDayOfWeek: 1 }
  });

  // Elements
  const datePicker = document.getElementById('datePicker');
  const courtSelect = document.getElementById('courtSelect');
  const searchBtn = document.getElementById('searchBtn');
  const slots = document.querySelectorAll('.slot');
  const selectedCount = document.getElementById('selectedCount');
  const totalPrice = document.getElementById('totalPrice');
  const selectedSlots = document.getElementById('selectedSlots');
  const bookBtn = document.getElementById('bookBtn');

  let selected = new Set();

  // Slot click
  slots.forEach(slot => {
    slot.addEventListener('click', () => {
      if (slot.classList.contains('booked')) return;

      const id = `${slot.dataset.courtId}-${slot.dataset.time}`;
      if (selected.has(id)) {
        selected.delete(id);
        slot.classList.remove('active');
      } else {
        selected.add(id);
        slot.classList.add('active');
      }
      updateSummary();
    });
  });

  // Update summary
  function updateSummary() {
    const count = selected.size;
    const pricePerHour = 200000;
    const total = count * pricePerHour;
    selectedCount.textContent = `${count} khung giờ được chọn`;
    totalPrice.textContent = new Intl.NumberFormat('vi-VN').format(total) + ' VND';

    selectedSlots.innerHTML = Array.from(selected).map(id => {
      const [court, time] = id.split('-');
      return `<div class="flex justify-between py-1">${time} - ${court}</div>`;
    }).join('');

    bookBtn.disabled = count === 0;
  }

  // Search - AJAX fetch availability
  searchBtn.addEventListener('click', () => {
    const date = datePicker.value;
    const courtId = courtSelect.value;
    if (date && courtId) {
      // TODO: AJAX /api/availability?date=...&courtId=...
      fetch(`/api/availability?date=${date}&courtId=${courtId}`)
        .then(res => res.json())
        .then(data => {
          // Update slots based on data
          updateSlots(data);
        });
    }
  });
}

function updateSlots(data) {
  // Implement based on backend response
  console.log('Update slots with:', data);
}

    function toggleUserMenu() {
    const menu = document.getElementById("userDropdown");
    menu.classList.toggle("hidden");
}

    // Click ra ngoài thì đóng menu
    document.addEventListener("click", function (event) {
    const menu = document.getElementById("userDropdown");
    const button = event.target.closest("button");

    // Nếu click ngoài button và ngoài menu
    if (!button && !menu.contains(event.target)) {
    menu.classList.add("hidden");
}
});
