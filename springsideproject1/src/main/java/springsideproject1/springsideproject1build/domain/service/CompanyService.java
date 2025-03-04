package springsideproject1.springsideproject1build.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springsideproject1.springsideproject1build.domain.entity.company.Company;
import springsideproject1.springsideproject1build.domain.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

import static springsideproject1.springsideproject1build.domain.error.constant.EXCEPTION_MESSAGE.ALREADY_EXIST_COMPANY_CODE;
import static springsideproject1.springsideproject1build.domain.error.constant.EXCEPTION_MESSAGE.NO_COMPANY_WITH_THAT_CODE;
import static springsideproject1.springsideproject1build.domain.valueobject.REGEX.NUMBER_REGEX_PATTERN;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyService {

    private final CompanyRepository companyRepository;

    /**
     * SELECT Company
     */
    public List<Company> findCompanies() {
        return companyRepository.getCompanies();
    }

    public Optional<Company> findCompanyByCode(String code) {
        return companyRepository.getCompanyByCode(code);
    }

    public Optional<Company> findCompanyByName(String name) {
        return companyRepository.getCompanyByName(name);
    }

    public Optional<Company> findCompanyByCodeOrName(String codeOrName) {
        return NUMBER_REGEX_PATTERN.matcher(codeOrName).matches() ? findCompanyByCode(codeOrName) : findCompanyByName(codeOrName);
    }

    /**
     * INSERT Company
     */
    @Transactional
    public void registerCompanies(Company... articles) {
        for (Company article : articles) {
            registerCompany(article);
        }
    }

    @Transactional
    public void registerCompany(Company company) {
        duplicateCheck(company);
        companyRepository.saveCompany(company);
    }

    /**
     * UPDATE Company
     */
    @Transactional
    public void correctCompany(Company company) {
        existentCheck(company.getCode());
        companyRepository.updateCompany(company);
    }

    /**
     * REMOVE Company
     */
    @Transactional
    public void removeCompanyByCode(String code) {
        existentCheck(code);
        companyRepository.deleteCompanyByCode(code);
    }

    /**
     * Other private methods
     */
    private void duplicateCheck(Company company) {
        companyRepository.getCompanyByCode(company.getCode()).ifPresent(
                v -> {throw new IllegalStateException(ALREADY_EXIST_COMPANY_CODE);}
        );
    }
    private void existentCheck(String code) {
        companyRepository.getCompanyByCode(code).orElseThrow(
                () -> new IllegalStateException(NO_COMPANY_WITH_THAT_CODE)
        );
    }
}
