import socket
from concurrent.futures import ThreadPoolExecutor

services = {
    21: "FTP",
    22: "SSH",
    23: "Telnet",
    25: "SMTP",
    53: "DNS",
    67: "DHCP (server)",
    68: "DHCP (client)",
    69: "TFTP",
    80: "HTTP",
    110: "POP3",
    123: "NTP",
    143: "IMAP",
    161: "SNMP",
    389: "LDAP",
    443: "HTTPS",
    465: "SMTPS",
    514: "Syslog",
    587: "SMTP (submission)",
    636: "LDAPS",
    993: "IMAPS",
    995: "POP3S",
}

open_ports = []

def scan_port(port):
    try:
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as sock:
            sock.settimeout(0.5)

            if sock.connect_ex((target, port)) == 0:
                service = services.get(port, "Unknown")
                print(f"[OPEN] Port {port} ({service})")
                open_ports.append(port)
    except:
        pass


def main():
    global target

    target = input("Enter Target IP: ")
    print("\n[+] Starting scan...\n")

    with ThreadPoolExecutor(max_workers=100) as executor:
        executor.map(scan_port, range(1, 1025))

    print("\n[+] SCAN COMPLETE\n")

    if open_ports:
        print(f"Open ports found: {len(open_ports)}")

        high_risk = [p for p in open_ports if p in [21, 23]]
        medium_risk = [p for p in open_ports if p in [80]]
        low_risk = [p for p in open_ports if p in [22, 443]]

        print("\n--- RISK ANALYSIS ---")

        if not high_risk and not medium_risk and not low_risk:
            print("No risks detected")

        if high_risk:
            print(f"[HIGH RISK] {high_risk} (Insecure services)")
        if medium_risk:
            print(f"[MEDIUM RISK] {medium_risk} (Web traffic)")
        if low_risk:
            print(f"[LOW RISK] {low_risk} (Secure services)")
    else:
        print("No open ports found.")

# Run only if the file is being ran directly
if __name__ == "__main__":
    main()