package in.cus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cus.entity.CustomerEntity;
import in.cus.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerEntity saveCustomer(CustomerEntity customer) {
		return customerRepository.save(customer);
	}

	@Override
	public CustomerEntity getCustomerById(Integer id) {
		Optional<CustomerEntity> customerOptional = customerRepository.findById(id);
		return customerOptional.orElse(null);
	}

	@Override
	public List<CustomerEntity> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void deleteCustomer(Integer id) {
		customerRepository.deleteById(id);
	}
}
