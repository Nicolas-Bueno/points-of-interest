# Pontos de Interesse por GPS

Este projeto consiste na implementação de um serviço para a empresa XY Inc., especializada na produção de receptores GPS (Global Positioning System). O objetivo é desenvolver uma plataforma baseada em serviços REST que forneça inteligência a um dispositivo de localização de pontos de interesse (POIs), permitindo que os usuários encontrem POIs próximos com base em sua localização atual.

## Exemplo

Considere a seguinte base de dados de POIs:

- 'Lanchonete' (x=27, y=12)
- 'Posto' (x=31, y=18)
- 'Joalheria' (x=15, y=12)
- 'Floricultura' (x=19, y=21)
- 'Pub' (x=12, y=8)
- 'Supermercado' (x=23, y=6)
- 'Churrascaria' (x=28, y=2)

Dado o ponto de referência (x=20, y=10) indicado pelo receptor GPS, e uma distância máxima de 10 metros, o serviço deve retornar os seguintes POIs:

- Lanchonete
- Joalheria
- Pub
- Supermercado

## Requisitos

- [x] Cadastrar pontos de interesse, com 03 atributos: nome do POI, coordenada X (inteiro não negativo) e coordenada Y (inteiro não negativo).
- [x] Os POIs devem ser armazenados em uma base de dados.
- [x] Listar todos os POIs cadastrados.
- [x] Listar os POIs por proximidade. Este serviço receberá uma coordenada X e uma coordenada Y, especificando um ponto de referência, bem como uma distância máxima (d-max) em metros. O serviço deverá retornar todos os POIs da base de dados que estejam a uma distância menor ou igual a d-max a partir do ponto de referência.

Desafio do Backend Brasil.
