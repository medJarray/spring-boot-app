package com.spring.app.spring5webapp.common;

import com.spring.app.spring5webapp.model.EmployerElement;
import lombok.NoArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@NoArgsConstructor
public class CsvFile {

    private static final String DEFAULT_ENCODING = "UTF-8";

    /**
     * For more information about super csv see :
     * https://memorynotfound.com/write-csv-file-super-csv/
     */
    public static InputStreamResource writeCsv(List<EmployerElement> employerElements) throws IOException {

        StringWriter st = new StringWriter();
        try (
                ICsvMapWriter mapWriter = new CsvMapWriter(st, CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE)
        ) {

            String[] header = new String[]{"First Name", "Last Name", "Matricule"};
            mapWriter.writeHeader(header);

            CellProcessor[] processors = new CellProcessor[header.length];
            for (final EmployerElement employer : employerElements) {

                Map<String, Object> mapData = new LinkedHashMap<>();
                mapData.put(header[0], employer.getFirstName());
                mapData.put(header[1], employer.getLastName());
                mapData.put(header[2], employer.getMatricule());

                mapWriter.write(mapData, header, processors);
            }
        }
        return (new InputStreamResource(new ByteArrayInputStream(st.toString().getBytes(DEFAULT_ENCODING))));
    }


}
