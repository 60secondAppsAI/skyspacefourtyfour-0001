package com.skyspacefourtyfour.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.skyspacefourtyfour.dao.GenericDAO;
import com.skyspacefourtyfour.service.GenericService;
import com.skyspacefourtyfour.service.impl.GenericServiceImpl;
import com.skyspacefourtyfour.dao.BookingDAO;
import com.skyspacefourtyfour.domain.Booking;
import com.skyspacefourtyfour.dto.BookingDTO;
import com.skyspacefourtyfour.dto.BookingSearchDTO;
import com.skyspacefourtyfour.dto.BookingPageDTO;
import com.skyspacefourtyfour.dto.BookingConvertCriteriaDTO;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;
import com.skyspacefourtyfour.service.BookingService;
import com.skyspacefourtyfour.util.ControllerUtils;





@Service
public class BookingServiceImpl extends GenericServiceImpl<Booking, Integer> implements BookingService {

    private final static Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Autowired
	BookingDAO bookingDao;

	


	@Override
	public GenericDAO<Booking, Integer> getDAO() {
		return (GenericDAO<Booking, Integer>) bookingDao;
	}
	
	public List<Booking> findAll () {
		List<Booking> bookings = bookingDao.findAll();
		
		return bookings;	
		
	}

	public ResultDTO addBooking(BookingDTO bookingDTO, RequestDTO requestDTO) {

		Booking booking = new Booking();

		booking.setBookingId(bookingDTO.getBookingId());


		booking.setBookingStatus(bookingDTO.getBookingStatus());


		booking.setBookingDate(bookingDTO.getBookingDate());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		booking = bookingDao.save(booking);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Booking> getAllBookings(Pageable pageable) {
		return bookingDao.findAll(pageable);
	}

	public Page<Booking> getAllBookings(Specification<Booking> spec, Pageable pageable) {
		return bookingDao.findAll(spec, pageable);
	}

	public ResponseEntity<BookingPageDTO> getBookings(BookingSearchDTO bookingSearchDTO) {
	
			Integer bookingId = bookingSearchDTO.getBookingId(); 
 			String bookingStatus = bookingSearchDTO.getBookingStatus(); 
   			String sortBy = bookingSearchDTO.getSortBy();
			String sortOrder = bookingSearchDTO.getSortOrder();
			String searchQuery = bookingSearchDTO.getSearchQuery();
			Integer page = bookingSearchDTO.getPage();
			Integer size = bookingSearchDTO.getSize();

	        Specification<Booking> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, bookingId, "bookingId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, bookingStatus, "bookingStatus"); 
			
 			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("bookingStatus")), "%" + searchQuery.toLowerCase() + "%") 
		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<Booking> bookings = this.getAllBookings(spec, pageable);
		
		//System.out.println(String.valueOf(bookings.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(bookings.getTotalPages()));
		
		List<Booking> bookingsList = bookings.getContent();
		
		BookingConvertCriteriaDTO convertCriteria = new BookingConvertCriteriaDTO();
		List<BookingDTO> bookingDTOs = this.convertBookingsToBookingDTOs(bookingsList,convertCriteria);
		
		BookingPageDTO bookingPageDTO = new BookingPageDTO();
		bookingPageDTO.setBookings(bookingDTOs);
		bookingPageDTO.setTotalElements(bookings.getTotalElements());
		return ResponseEntity.ok(bookingPageDTO);
	}

	public List<BookingDTO> convertBookingsToBookingDTOs(List<Booking> bookings, BookingConvertCriteriaDTO convertCriteria) {
		
		List<BookingDTO> bookingDTOs = new ArrayList<BookingDTO>();
		
		for (Booking booking : bookings) {
			bookingDTOs.add(convertBookingToBookingDTO(booking,convertCriteria));
		}
		
		return bookingDTOs;

	}
	
	public BookingDTO convertBookingToBookingDTO(Booking booking, BookingConvertCriteriaDTO convertCriteria) {
		
		BookingDTO bookingDTO = new BookingDTO();
		
		bookingDTO.setBookingId(booking.getBookingId());

	
		bookingDTO.setBookingStatus(booking.getBookingStatus());

	
		bookingDTO.setBookingDate(booking.getBookingDate());

	

		
		return bookingDTO;
	}

	public ResultDTO updateBooking(BookingDTO bookingDTO, RequestDTO requestDTO) {
		
		Booking booking = bookingDao.getById(bookingDTO.getBookingId());

		booking.setBookingId(ControllerUtils.setValue(booking.getBookingId(), bookingDTO.getBookingId()));

		booking.setBookingStatus(ControllerUtils.setValue(booking.getBookingStatus(), bookingDTO.getBookingStatus()));

		booking.setBookingDate(ControllerUtils.setValue(booking.getBookingDate(), bookingDTO.getBookingDate()));



        booking = bookingDao.save(booking);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public BookingDTO getBookingDTOById(Integer bookingId) {
	
		Booking booking = bookingDao.getById(bookingId);
			
		
		BookingConvertCriteriaDTO convertCriteria = new BookingConvertCriteriaDTO();
		return(this.convertBookingToBookingDTO(booking,convertCriteria));
	}







}
