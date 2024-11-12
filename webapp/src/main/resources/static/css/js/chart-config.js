// chart-config.js
document.addEventListener('DOMContentLoaded', function() {
    var ctx = document.getElementById('projectCollaborators').getContext('2d');
    var projectCollaboratorsChart = new Chart(ctx, {
        type: 'doughnut', // Type de graphique (donut)
        data: {
            labels: ['Commercial', 'Technique', 'Support', 'Marketing'], // Départements
            datasets: [{
                label: 'Nombre de collaborateurs',
                data: [12, 19, 3, 5], // Données correspondantes à chaque département
                backgroundColor: [
                    'rgba(52, 152, 219, 0.6)',  // Couleurs des segments
                    'rgba(46, 204, 113, 0.6)',
                    'rgba(231, 76, 60, 0.6)',
                    'rgba(241, 196, 15, 0.6)'
                ],
                borderColor: [
                    'rgba(52, 152, 219, 1)',
                    'rgba(46, 204, 113, 1)',
                    'rgba(231, 76, 60, 1)',
                    'rgba(241, 196, 15, 1)'
                ],
                borderWidth: 1 // Largeur des bordures des segments
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: {
                    position: 'top', // Position de la légende
                },
                tooltip: {
                    callbacks: {
                        label: function(tooltipItem) {
                            return tooltipItem.label + ': ' + tooltipItem.raw;
                        }
                    }
                }
            }
        }
    });


    // // Vérifiez que l'élément canvas existe avant d'initialiser Chart.js
    // const ctx = document.getElementById('projectCollaborators');
    // if (ctx) {
    //     const myDoughnutChart = new Chart(ctx, config);
    // } else {
    //     console.error('Element with id "projectCollaborators" not found.');
    // }
});
