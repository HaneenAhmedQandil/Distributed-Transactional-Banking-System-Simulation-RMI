# Distributed Transactional Banking System Simulation with RMI

## Overview
This project simulates a distributed transactional banking system using Java RMI (Remote Method Invocation). It features a decentralized architecture where master servers manage client transactions across different regions, supported by regional servers for localized management. The system provides a graphical user interface (GUI) for both the master servers and clients, facilitating easy monitoring, management, and transaction operations.

## Code Structure

### System Initialization
1. **Master Servers**: The system initializes two master server instances, `MasterServerImp_1` and `MasterServerImp_2`, responsible for managing clients and transactions across different regions.
2. **Master Server GUIs**: For each master server, a corresponding GUI instance (`MasterServerGUI_1` and `MasterServerGUI_2`) is started. These GUIs allow for the visual monitoring and management of the master servers.
3. **Regional Servers**: Regional server implementations for Banha, Nasr City, Zamalek, Maadi, Zayed, and Mohandeseen are initialized. Each server registers its initial clients and itself with the appropriate master server.
4. **Client and Balance Display**: The master server GUIs display a list of clients and their balances for each region under their management.

### Transaction Process
1. **Client GUI**: Clients interact with the system through the `Client_Transaction_GUI` application, where they can perform transactions such as deposits, withdrawals, or balance checks.
2. **Region Selection and RMI Connection**: Based on the selected region, the client GUI connects to the appropriate master server using RMI.
3. **Transaction Requests**: For deposits or withdrawals, clients enter an amount, and the GUI sends a request to the master server, which then forwards it to the regional server. The regional server updates the client's balance accordingly.
4. **Balance Checks**: For balance inquiries, the GUI sends a request to the master server, which forwards it to the regional server to retrieve the client's balance.
5. **Display Updates**: The master server GUIs update their displays to reflect the latest balances after transactions.

## Handling User Input
- **Error Handling**: The system robustly handles various user input errors, including:
  1. Non-numerical values in the amount field.
  2. Transactions requested by users not existing in the specified region.
  3. Incomplete fields in the transaction GUI.

## Getting Started
To run this project, ensure you have Java and the Java RMI library installed. Follow these steps:
1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Compile the Java files using your preferred Java compiler.
4. Start the RMI registry.
5. Launch the master server instances and their GUIs.
6. Initialize the regional servers.
7. Run the `Client_Transaction_GUI` to start performing transactions.

## Contributing
Contributions to the Distributed Transactional Banking System Simulation are welcome. Please ensure to follow the project's coding standards and submit your pull requests for review.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
