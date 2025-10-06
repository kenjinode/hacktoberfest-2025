import speedtest
import time

def check_internet_speed():
    """
    Check internet download and upload speeds using speedtest-cli.
    Returns download speed, upload speed, and ping in Mbps and ms.
    """
    try:
        # Initialize speedtest
        st = speedtest.Speedtest()
        
        # Select best server
        print("Finding best server...")
        st.get_best_server()
        
        # Perform download speed test
        print("Testing download speed...")
        download_speed = st.download() / 1_000_000  # Convert to Mbps
        
        # Perform upload speed test
        print("Testing upload speed...")
        upload_speed = st.upload() / 1_000_000  # Convert to Mbps
        
        # Get ping
        ping = st.results.ping
        
        # Return results
        return {
            "download_speed_mbps": round(download_speed, 2),
            "upload_speed_mbps": round(upload_speed, 2),
            "ping_ms": round(ping, 2)
        }
    
    except Exception as e:
        return {"error": f"An error occurred: {str(e)}"}

def main():
    print("Starting internet speed test...\n")
    start_time = time.time()
    
    results = check_internet_speed()
    
    if "error" in results:
        print(results["error"])
    else:
        print("\nSpeed Test Results:")
        print(f"Download Speed: {results['download_speed_mbps']} Mbps")
        print(f"Upload Speed: {results['upload_speed_mbps']} Mbps")
        print(f"Ping: {results['ping_ms']} ms")
        print(f"\nTest completed in {round(time.time() - start_time, 2)} seconds")

if __name__ == "__main__":
    main()
  
