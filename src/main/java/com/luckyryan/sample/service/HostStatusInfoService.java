package com.luckyryan.sample.service;

import java.util.List;

import com.luckyryan.sample.dao.model.HostStatusInfo;
import com.luckyryan.sample.exception.InvalidDataException;

public interface HostStatusInfoService {
	public HostStatusInfo saveInfo(HostStatusInfo user) throws InvalidDataException;
	public HostStatusInfo getInfo(Long id) throws InvalidDataException;
	public HostStatusInfo getHostByMacAddress(String macAddress) throws InvalidDataException;
	
	public List<HostStatusInfo> getAll(Long userId) throws InvalidDataException;
	public List<HostStatusInfo> getAllHostList() throws InvalidDataException;
	public List<HostStatusInfo> getAssignedHostList(Long userId) throws InvalidDataException;
	
	public int updateDisconnectedHostStatus(String newStatus)  throws InvalidDataException;
	public String deleteHostInfo(Long hostId)  throws InvalidDataException;
	
	public String assignUserToHost(Long userId, Long hostId) throws InvalidDataException;
	public String enableHost(Long userId, Boolean isEnable) throws InvalidDataException;
}
