

states_needed = set(["mt", "wa", "or", "id", "nv", "ut", "ca", "az"])
stations = {} 
stations["kone"] = set(["id", "nv", "ut"]) 
stations["ktwo"] = set(["wa", "id", "mt"]) 
stations["kthree"] = set(["or", "nv", "ca"]) 
stations["kfour"] = set(["nv", "ut"]) 
stations["kfive"] = set(["ca", "az"]) 
final_stations = set() 

# while states_needed:
#     best_station = None
#     states_coverd = set()

#     for station, state_for_station in stations.items():
#         covered = states_needed & state_for_station
#         if len(covered) > len(states_coverd):
#             best_station = station
#             states_coverd = covered
#     states_needed -= states_coverd
#     final_stations.add(best_station)


# print(final_stations)


while states_needed:
    best_station = None
    state_covered = set()
    for station, state_for_station in stations.items():
        covered = states_needed & state_for_station
        if len(covered) > len(state_covered):
            best_station = station 
            state_covered = covered
    states_needed -= state_covered
    final_stations.add(best_station)

print(final_stations)